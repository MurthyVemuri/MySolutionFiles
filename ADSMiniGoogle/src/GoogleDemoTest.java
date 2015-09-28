import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class WebPage {

	public String getContent(String url) throws Exception {
	String content = "";
	URL oracle = new URL(url);
	BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
	String inputLine;
	while ((inputLine = in.readLine()) != null) {
		content = content + inputLine;
	}
	in.close();
	return content;
	}


	public List<String> getAllLinks(String content) {
		int check = 0;
		List<String> urls = new ArrayList<String>();
		while (true) {
			int startIndex = content.indexOf("a href=\"") + 8;
			String newcontent = content.substring (startIndex);
			check = startIndex ;
			if(check == 7)
				break;
			startIndex = 0;
			int stopIndex = newcontent.indexOf("\"" );
			String url = newcontent.substring(startIndex , stopIndex );
			content = newcontent.substring (stopIndex + 1 );
			urls.add(url);
		}
		return urls;
	}


	public List<String> getWords(String content) {
		content = content.replaceAll("<[^>]*>" , " ");
		content = content.replaceAll("[^a-zA-Z]" , " ");
		StringTokenizer st = new StringTokenizer(content, " ");
		List<String> words = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			words.add(st.nextToken());
		}
		return words;
	}


	@SuppressWarnings("resource")
	public List<String>  getStopWords(String fileName){
		List<String> stopWords = new ArrayList<String>();
		BufferedReader br = null;
		String sCurrentLine;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				String stopWord = sCurrentLine ;
				stopWords.add(stopWord);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stopWords;
	}

	public List<String> getKeyWords(List<String> wordsArray, List<String> stopWordsArray) {
		int flag =0;
		List<String> keyWordsArray = new ArrayList<String>();
		for(String word : wordsArray) {
			flag =0;
			for(String stopWord : stopWordsArray) {
				if(word.compareToIgnoreCase(stopWord) == 0) {
					flag=1;
					break;
				}
			}
			if(flag == 0){
				keyWordsArray.add(word);
			}
				 
		}
		return keyWordsArray;
	}

}


class CrawlWeb {

	public List<String> crawl(String url) throws Exception {

		WebPage wp = new WebPage();

		List<String> finalUrl = new ArrayList<String>();
		List<String> allLinks = new ArrayList<String>();

		finalUrl.add(url);
		int flag = 0;
		for (int i = 0; i <  finalUrl.size(); i++) {
			allLinks = wp.getAllLinks(finalUrl.get(i));
			for (String newUrl : allLinks) {
				flag = 0;
				for (String checkUrl : finalUrl) {
					if(checkUrl.equals(newUrl))
					flag = 1;
				}
				if(flag == 0) {
				finalUrl.add(newUrl);
				}
			}
		}
		return finalUrl;
	}
}


public class GoogleDemoTest {

	public static void main(String[] args) throws Exception {
		try {
			WebPage webpage = new WebPage();
			String seedUrl = "http://minigoogle.msitprogram.net/";
			String pageContent = webpage.getContent(seedUrl);
//			System.out.println(pageContent);

			List<String> allUrls = new ArrayList<String>();
			allUrls = webpage.getAllLinks(pageContent);
			for (String strings : allUrls)
				System.out.println(strings);

			List<String> wordsArray = new ArrayList<String>();
			wordsArray = webpage.getWords(pageContent);
/*			for (String word : wordsArray)
				System.out.println(word);*/

			List<String> stopWordsArray = new ArrayList<String>();
			stopWordsArray = webpage.getStopWords("StopWords.txt");
/*			for (String word : stopWordsArray)
				System.out.println(word);*/

			List<String> keyWordsArray = new ArrayList<String>();
			keyWordsArray = webpage.getKeyWords(wordsArray, stopWordsArray);
			for (String keyWord : keyWordsArray)
			System.out.println(keyWord);

			CrawlWeb crawlweb = new CrawlWeb();
			List<String> totalLinks = new ArrayList<String>();
			totalLinks = crawlweb.crawl(seedUrl);
			for (String link : totalLinks) {
				System.out.println(link);
			}


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}