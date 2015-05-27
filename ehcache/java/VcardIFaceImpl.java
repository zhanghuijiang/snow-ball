package com.vcard.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.vcard.cache.TokenCache;
import com.vcard.cache.VcardCache;
import com.vcard.cache.target.CacheVcardIFace;
import com.vcard.dao.Vcard_code;
import com.vcard.dao.Vcard_notice;
import com.vcard.dao.Vcard_user;
import com.vcard.dao.Vcard_user_favorites;
import com.vcard.dao.Vcard_user_feedback;
import com.vcard.dao.Vcard_uservitality;
import com.vcard.iface.VcardIFace;
import com.vcard.servlet.WeixinUtil;
import com.vcard.util.Client;
import com.vcard.util.Config;
import com.vcard.util.DbUtils;
import com.vcard.util.Logger;
import com.vcard.util.Pagination;

public class VcardIFaceImpl extends CacheVcardIFace implements VcardIFace {
	
}
