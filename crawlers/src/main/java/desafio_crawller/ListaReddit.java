package desafio_crawller;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListaReddit {

	public static void main(String[] args) throws InterruptedException {
		String nomes = "askreddit;worldnews;cats";
		String lista[] = nomes.split(";");

		ArrayList<String> upvotes = new ArrayList<String>();
		ArrayList<String> subreedit = new ArrayList<String>();
		ArrayList<String> titulo = new ArrayList<String>();
		ArrayList<String> linkSubreddit = new ArrayList<String>();
		//vetor de subreddits  e arrays upvotes subreedit titulo linkSubreddit
		listaSubrredit(lista, upvotes, subreedit, titulo, linkSubreddit);
		imprir(upvotes, subreedit, titulo, linkSubreddit);
	}

	public static void imprir(ArrayList<String> upvotes, ArrayList<String> subreedit, ArrayList<String> titulo,ArrayList<String> linkSubreddit) {
		
		boolean upvote;
		for (int i = 0; i < upvotes.size(); i++) {
			if (!(upvotes.get(i).equals("•"))) {
				upvote = upvotes.get(i).contains("k");
				if (upvote || Integer.parseInt(upvotes.get(i)) >= 5000) {
					System.out.println("Upvotes: " + upvotes.get(i) + "\n" 
							+ "Subreedit: r/" + subreedit.get(i) + "\n"
							+ "Titulo: " + titulo.get(i) + "\n" 
							+ "Link: " + linkSubreddit.get(i) + "\n");
				}
			}
		}
	}

	public static void listaSubrredit(String lista[], ArrayList<String> upvotes, ArrayList<String> subreedit,
			ArrayList<String> titulo, ArrayList<String> linkSubreddit) {

		int i = 0;
		while (lista.length > i) {

			try {
				Document doc = Jsoup.connect("https://old.reddit.com/r/" + lista[i]).get();
				Elements eupvotes = doc.select("div[class=score unvoted]");
				Elements etituloLink = doc.select("div[class=top-matter]>p[class=title]>a");

				for (Element reddit : eupvotes) {
					upvotes.add(reddit.text());
					subreedit.add(lista[i]);
				}
				for (Element reddit : etituloLink) {
					titulo.add(reddit.text());
				}
				for (Element reddit : etituloLink) {
					linkSubreddit.add(reddit.attr("abs:href"));
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
	}
}