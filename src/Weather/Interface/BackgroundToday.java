package Weather.Interface;

import javafx.scene.layout.AnchorPane;

public class BackgroundToday {

    public static void setBackground(AnchorPane background, String description) {

        switch (description) {

            case "Burza z lekkimi opadami deszczu":
            case "Burza z opadami deszczu":
            case "Burza z ulewnym deszczem": background.setStyle("-fx-background-color: #383a42"); break;

            case "Słaba burza z piorunami":
            case "Burza z piorunami":
            case "Silna burza z piorunami": background.setStyle("-fx-background-color: #1f2024"); break;

            case "Burza z przejasnieniami":
            case "Burza z lekką mżawką":
            case "Burza z mrzawką":
            case "Burza z gęstą mżawką": background.setStyle("-fx-background-color: #363d59"); break;

            case "Lekka mżawka":
            case "Mżawka":
            case "Intensywna mżawka":
            case "Lekka mżawka z deszczem":
            case "Mżawka z deszczem":
            case "Intensywna mżawka z deszczem":
            case "Przelotne opady z mżawką":
            case "Przelotna ulewa z mżawką":
            case "Przelotna mżawka": background.setStyle("-fx-background-color: #36608f"); break;

            case "Lekki deszcz":
            case "Umiarkowany deszcz":
            case "Lekki, przelotny deszcz":
            case "Przelotny deszcz":
            case "Intensywny, przelotny deszcz":
            case "Przelotny deszcz z przejaśnieniami": background.setStyle("-fx-background-color: #336cab"); break;

            case "Intensywny deszcz":
            case "Ulewa":
            case "Ekstremalna ulewa":
            case "Marznący deszcz": background.setStyle("-fx-background-color: #1d3754"); break;

            case "Lekki śnieg":
            case "Śnieg":
            case "Duże opady śniegu":
            case "Śnieg z deszczem":
            case "Lekki, przelotny śnieg z deszczem":
            case "Przelotny śnieg z deszczem":
            case "Lekki deszcz ze śniegiem":
            case "Deszcz ze śniegiem":
            case "Lekki, przelotny śnieg":
            case "Przelotny śnieg":
            case "Intensywny, przelotny śnieg": background.setStyle("-fx-background-color: #464f59"); break;

            case "Lekka mgła":
            case "Lekka, przyziemna mgła":
            case "Mgła": background.setStyle("-fx-background-color: #989fa6"); break;

            case "Zadymienie":
            case "Wiry piasku/pyłu":
            case "Piasek":
            case "Pył":
            case "Pył wulkaniczny":
            case "Szkwał":
            case "Tornado": background.setStyle("-fx-background-color: #696969"); break;

            case "Czyste niebo": background.setStyle("-fx-background-color: #faf734"); break;

            case "Lekkie zachmurzenie (11-25%)": background.setStyle("-fx-background-color: #dedc57"); break;
            case "Częściowe zachmurzenie (25-50%)": background.setStyle("-fx-background-color: #dbda76"); break;
            case "Pochmurno (51-84%)":
            case "Całkowite zachmurzenie": background.setStyle("-fx-background-color: #919167"); break;

        }
    }
}
