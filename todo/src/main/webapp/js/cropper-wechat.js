(function (factory) {
  if (typeof define === 'function' && define.amd) {
    define(['jquery'], factory);
  } else if (typeof exports === 'object') {
    // Node / CommonJS
    factory(require('jquery'));
  } else {
    factory(jQuery);
  }
})(function ($) {

  'use strict';

  var console = window.console || { log: function () {} };
  

  function CropAvatar($element) {
	  
    this.$container = $element;

    this.$avatarView = this.$container.find('.avatar-view');
    
    this.$avatarModal = this.$container.find('#avatar-modal');
    this.$loading = this.$container.find('.loading');
    this.$cancel = this.$container.find('.cancel');
    this.$done = this.$container.find('.done');
    
    this.$avatarForm = this.$avatarModal.find('.avatar-form');
    this.$avatarUpload = this.$avatarForm.find('.avatar-upload');
    this.$avatarSrc = this.$avatarForm.find('.avatar-src');
    this.$avatarData = this.$avatarForm.find('.avatar-data');
    this.$avatarInput = this.$avatarForm.find('.avatar-input');
    this.$avatarSave = this.$avatarForm.find('.avatar-save');

    this.$avatarWrapper = this.$avatarModal.find('.avatar-wrapper');

    this.init();
    
  }

  CropAvatar.prototype = {
		  
    constructor: CropAvatar,

    support: {
      fileList: !!$('<input type="file">').prop('files'),
      blobURLs: !!window.URL && URL.createObjectURL,
      formData: !!window.FormData
    },

    init: function () {
    
      this.support.datauri = this.support.fileList && this.support.blobURLs;
      
      this.addListener();
      
    },

    addListener: function () {
      this.$avatarView.on('click', $.proxy(this.click, this));
      this.$cancel.on('click', $.proxy(this.cropDone, this));
      this.$done.on('click', $.proxy(this.submit, this));
      this.$avatarInput.on('change', $.proxy(this.change, this));
    },
    click: function () {
    	this.$avatarInput.click();
    },
    change: function () {
      var files,
          file;
      
      if (this.support.datauri) {
    	this.$avatarWrapper.show();
        files = this.$avatarInput.prop('files');
        if (files.length > 0) {
          file = files[0];
          if (this.isImageFile(file)) {
            if (this.url) {
              URL.revokeObjectURL(this.url); // Revoke the old one
            }
            this.url = URL.createObjectURL(file);
            this.startCropper();
          }
        }
      } else {
        file = this.$avatarInput.val();

        if (this.isImageFile(file)) {
          this.syncUpload();
        }
      }
    },

    submit: function () {
    	
      if (!this.$avatarSrc.val() && !this.$avatarInput.val()) {
        return false;
      }

      if (this.support.formData) {
        this.ajaxUpload();
        return false;
      }
      
    },
    isImageFile: function (file) {
      if (file.type) {
        return /^image\/\w+$/.test(file.type);
      } else {
        return /\.(jpg|jpeg|png|gif)$/.test(file);
      }
    },
    startCropper: function () {
      var _this = this;
      if (this.active) {
        this.$img.cropper('replace', this.url);
      } else {
    	var width = this.$avatarWrapper.width();
        this.$img = $('<img src="' + this.url + '">');
        this.$avatarWrapper.empty().html(this.$img);
        this.$img.cropper({
          autoCropArea: 0.6,
          dragCrop:false,
          guides:false,
          cropBoxResizable:false,
          cropBoxMovable:false,
          rotatable:false,
          background : false,
          minContainerWidth:width,
          minCanvasWidth:width,
          minCropBoxWidth:width,
          minCropBoxHeight:200,
          crop: function (data) {
            var json = [
                  '{"x":' + data.x,
                  '"y":' + data.y,
                  '"height":' + data.height,
                  '"width":' + data.width,
                  '"rotate":' + data.rotate + '}'
                ].join();
            _this.$avatarData.val(json);
          }
        });
        
        this.active = true;
      }
    },

    stopCropper: function () {
      if (this.active) {
    	this.$avatarWrapper.hide()  
        this.$img.cropper('destroy');
        this.$img.remove();
        this.active = false;
      }
    },

    ajaxUpload: function () {
      var url = this.$avatarForm.attr('action'),
          data = new FormData(this.$avatarForm[0]),
          _this = this;
      
      $.ajax(url, {
        type: 'post',
        data: data,
        dataType: 'json',
        processData: false,
        contentType: false,

        beforeSend: function () {
          _this.submitStart();
        },

        success: function (data) {
          _this.submitDone(data);
        },

        error: function (XMLHttpRequest, textStatus, errorThrown) {
          _this.submitFail(textStatus || errorThrown);
        },

        complete: function () {
          _this.submitEnd();
        }
      });
    },

    syncUpload: function () {
      this.$avatarSave.click();
    },

    submitStart: function () {
      this.$loading.fadeIn();
    },

    submitDone: function (data) {

      if ($.isPlainObject(data) && data.state === 200) {
        if (data.result) {
          this.url = data.result;

          if (this.support.datauri || this.uploaded) {
            this.uploaded = false;
            this.cropDone();
          } else {
            this.uploaded = true;
            this.$avatarSrc.val(this.url);
            this.startCropper();
          }

          this.$avatarInput.val('');
        } else if (data.message) {
           console.log(data.message);
        }
      } else {
    	  console.log('Failed to response');
      }
    },

    submitFail: function (msg) {
      console.log(msg);
    },

    submitEnd: function () {
      this.$loading.fadeOut();
    },

    cropDone: function () {
      this.$avatarForm.get(0).reset();
      this.stopCropper();
    }
  };

  $(function () {
    return new CropAvatar($('#crop-avatar'));
  });

});
