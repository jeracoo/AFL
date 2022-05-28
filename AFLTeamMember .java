//AFLTeamMember.java//
import java.io.*;
import java.util.Scanner;
//code monkey//

public class AFLTeamMember {
        private String name;
        private String position;
        
        public AFLTeamMember(String name, String position) {
                setName(name);
                setPosition(position);
                        
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getPosition() {
                return position;
        }
        public void setPosition(String position) {
                position=position.trim();
                try {
                        if(position.equals("FB")||position.equals("HB")||position.equals("C")||position.equals("HF")||position.equals("FF")||position.equals("FOL")||position.equals("IC")||position.equals("COACH"))
                                this.position = position;
                        else
                                throw new Exception("Invalid position!");
                }catch(Exception e) {
                        System.out.println(e);
                }
        }
        public String toString() {
                return name+", "+position;
        }
}
//end of AFLTeamMember.java//




