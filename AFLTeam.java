//AFLTeam.java//
import java.io.*;
import java.util.Scanner;


public class AFLTeam {
        private String name;
        private AFLTeamMember coach;
        private AFLPlayer lineup[];
        public AFLTeam(String name, AFLTeamMember coach, AFLPlayer[] lineup) {
                super();
                this.name = name;
                this.coach = coach;
                this.lineup = lineup;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public AFLTeamMember getCoach() {
                return coach;
        }
        public void setCoach(AFLTeamMember coach) {
                this.coach = coach;
        }
        public AFLPlayer[] getLineup() {
                return lineup;
        }
        public void setLineup(AFLPlayer[] lineup) {
                this.lineup = lineup;
        }
        
}
//end of AFLTeam.java//



