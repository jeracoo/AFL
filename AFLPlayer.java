//AFLPlayer.java//
import java.io.*;
import java.util.Scanner;

public class AFLPlayer extends AFLTeamMember {
        private int number;
        private boolean isCaptain;
        public AFLPlayer(String name, String position,int number,boolean isCaptain) {
                super(name, position);
                setNumber(number);
                setCaptain(isCaptain);
        }
        public int getNumber() {
                return number;
        }
        public void setNumber(int number) {
                try {
                        if(number>0)
                                this.number = number;
                        else
                                throw new Exception("Invaid player number!");
                }catch(Exception e) {
                        System.out.println(e);
                }
        }
        public boolean isCaptain() {
                return isCaptain;
        }
        public void setCaptain(boolean isCaptain) {
                this.isCaptain = isCaptain;
        }
        public String toString() {
                if(isCaptain)
                        return "["+number+"] "+super.toString()+" (c)";
                return "["+number+"] "+super.toString();
        }
}
//end of AFLPlayer.java//
