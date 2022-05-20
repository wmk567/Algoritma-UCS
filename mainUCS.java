import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mainUCS {

    public static Comparator<UCS> sortNilai = new Comparator<UCS>() {
        public int compare (UCS u1, UCS u2){
            int no1 = u1.getCostFinal();
            int no2 = u2.getCostFinal();
            return no1-no2;
        }
    };

    public static void main(String[] args) {
        
        ArrayList<UCS> arrUCS = new ArrayList<UCS>();
        arrUCS.add(0, new UCS("A"));
        arrUCS.add(1, new UCS("B"));
        arrUCS.add(2, new UCS("C"));
        arrUCS.add(3, new UCS("D"));
        arrUCS.add(4, new UCS("E"));
        arrUCS.add(5, new UCS("F"));
        arrUCS.add(6, new UCS("G"));
        arrUCS.add(7, new UCS("H"));
        arrUCS.add(8, new UCS("I"));
        arrUCS.add(9, new UCS("J"));
        arrUCS.add(10, new UCS("K"));
        arrUCS.add(11, new UCS("L"));
        arrUCS.add(12, new UCS("M"));
        arrUCS.add(13, new UCS("N"));
        arrUCS.get(0).setConnection("B", 660);
        arrUCS.get(0).setConnection("C", 440);
        arrUCS.get(1).setConnection("D", 690);
        arrUCS.get(1).setConnection("E", 540);
        arrUCS.get(1).setConnection("F", 760);
        arrUCS.get(2).setConnection("G", 1280);
        arrUCS.get(3).setConnection("H", 535);
        arrUCS.get(4).setConnection("H", 500);
        arrUCS.get(4).setConnection("I", 400);
        arrUCS.get(5).setConnection("I", 300);
        arrUCS.get(6).setConnection("F", 1070);
        arrUCS.get(6).setConnection("J", 850);
        arrUCS.get(7).setConnection("K", 860);
        arrUCS.get(8).setConnection("J", 510);
        arrUCS.get(8).setConnection("K", 1320);
        arrUCS.get(9).setConnection("L", 300);
        arrUCS.get(9).setConnection("F", 500);
        arrUCS.get(10).setConnection("M", 380);
        arrUCS.get(10).setConnection("N", 750);
        arrUCS.get(11).setConnection("M", 930);
        arrUCS.get(12).setConnection("K", 380);
        arrUCS.get(12).setConnection("N", 860);

        ArrayList<String> checked = new ArrayList<>();
        ArrayList<UCS> queue = new ArrayList<>();

        //menambahkan simpul A ke queue awal
        queue.add(arrUCS.get(0));
        int iterasi = 0;

        while(queue.size() != 0){
            iterasi++;
            if (queue.get(0).getName() == "N"){
                System.out.println("iterasi " + iterasi);
                System.out.println("Simpul akhir: " + queue.get(0).getName());
                System.out.println("Skor akhir: " + queue.get(0).getCostFinal());
                System.out.println("Path: " + queue.get(0).getPath());
                queue = new ArrayList<>();
            }

            else{
                System.out.println("iterasi " + iterasi);
                System.out.println("Simpul E: " + queue.get(0).getName());
                
                for (int i = 0; i<queue.get(0).getConnection().size(); i++){
                    Boolean isFound = false;
                    for (int j = 0; j<checked.size(); j++){
                        if (queue.get(0).getConnection().get(i).getName() == checked.get(j)){
                            isFound = true;
                        }
                    }
                    if (isFound == false){
                        ArrayList<UCS> tempArrUCS = new ArrayList<>();
                        for (int k = 0; k<arrUCS.size(); k++){
                            UCS tempUCS = new UCS(arrUCS.get(k));
                            tempArrUCS.add(tempUCS);
                        }
                        
                        for (int k = 0; k<arrUCS.size(); k++){
                            String connectName = queue.get(0).getConnection().get(i).getName();
                            if (arrUCS.get(k).getName() == connectName){
                                UCS tempUCS = tempArrUCS.get(k);
                                int tempScore = queue.get(0).getConnection().get(i).getScore() 
                                                + queue.get(0).getCostFinal();

                                tempUCS.setCostFinal(tempScore);
                                tempUCS.setPath(queue.get(0).getPath() + queue.get(0).getName());
                                queue.add(tempUCS);
                                break;
                            }
                        }
                    }
                }

                Collections.sort(queue,sortNilai);
                checked.add(queue.get(0).getName());
                queue.remove(0);

                System.out.println("Simpul hidup: ");
                for (int i = 0; i<queue.size(); i++){
                    System.out.println(queue.get(i).getName() + " " + queue.get(i).getPath() + "-" + queue.get(i).getCostFinal());
                }
                System.out.println();
            }
        }


    }
}

