package webcrawler.htmlparser;

import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class Test {
	public static void main(String[] args) {
		try {
			Parser parser = new Parser("http://www.zuzhili.com");
			parser.setEncoding("utf-8");
			NodeList list = parser.parse(new TagNameFilter("div"));
			System.out.println(list.toHtml());
//			System.out.println(""+list.toHtml());
//			NodeList html = list.extractAllNodesThatMatch();
//			System.out.println("html："+html.toHtml());
		} catch (ParserException pe) {
			pe.printStackTrace();
		}
	}
}
