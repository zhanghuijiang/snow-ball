package lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

/**
 * Search all text files under a index.
 * @author arvin
 *
 */
public class SearchFiles {

	public static void main(String[] args) throws Exception {
		
		String index = "D:/lucene/index";
		String field = "contents";
		
		String queryString = "txt";
		int hitsPerPage = 4;

		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
		
		IndexSearcher searcher = new IndexSearcher(reader);
		Analyzer analyzer = new StandardAnalyzer();
		
		QueryParser parser = new QueryParser(field, analyzer);
		Query query = parser.parse(queryString);
		
		System.out.println("Searching for: " + query.toString(field));
		
		doPagingSearch(searcher, query, hitsPerPage);
		
		reader.close();

	}

	public static void doPagingSearch(IndexSearcher searcher, Query query, int hitsPerPage) throws IOException {

		// Collect enough docs to show 5 pages
		TopDocs results = searcher.search(query, 5 * hitsPerPage);
		ScoreDoc[] hits = results.scoreDocs;
		
		int numTotalHits = results.totalHits;
		System.out.println(numTotalHits + " total matching documents");

		int start = 0;
		int end = Math.min(numTotalHits, hitsPerPage);
        
		System.out.println(start +" to "+end);
		
		for (int i = start; i < end; i++) {
			Document doc = searcher.doc(hits[0].doc);
			System.out.println("doc=" + hits[i].doc);
			System.out.println("score="+ hits[i].score);
			String path = doc.get("path");
			System.out.println("path=" + path);
		}
		

	}

}
