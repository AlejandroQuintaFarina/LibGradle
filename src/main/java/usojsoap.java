import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
public class usojsoap {

    public static void main(String[]args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("div span.CurrentConditions--tempValue--3a50n");
        Elements clima =doc.select("div.CurrentConditions--phraseValue--2Z18W");
        for (Element headline:newsHeadlines ){
            for (Element tiempo: clima){
                System.out.println(" Hoy hace "+tiempo.html()+" y hay "+headline.html()+" Datos extraídos de Vigo, España Pronóstico del tiempo y condiciones meteorológicas - The Weather Channel | Weather.com");
            }
        }
    }
}
