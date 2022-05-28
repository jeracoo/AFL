//AFLMatch.java//
//Why the frick isn't it working//
import java.io.*;
import java.util.Scanner;


public class AFLMatch {
        private AFLTeam homeTeam;
        private AFLTeam awayTeam;
        private int homeTeamScore1,awayTeamScore1;
        private double homeTeamScore2,awayTeamScore2;
        public AFLMatch(AFLTeam homeTeam, AFLTeam awayTeam) {
                super();
                this.homeTeam = homeTeam;
                this.awayTeam = awayTeam;
                this.homeTeamScore1=0;
                this.homeTeamScore2=0.0;
                this.awayTeamScore1=0;
                this.awayTeamScore2=0.0;
        }
        public AFLTeam getHomeTeam() {
                return homeTeam;
        }
        public void setHomeTeam(AFLTeam homeTeam) {
                this.homeTeam = homeTeam;
        }
        public AFLTeam getAwayTeam() {
                return awayTeam;
        }
        public void setAwayTeam(AFLTeam awayTeam) {
                this.awayTeam = awayTeam;
        }
        public int getHomeTeamScore1() {
                return homeTeamScore1;
        }
        public void setHomeTeamScore1(int homeTeamScore1) {
                this.homeTeamScore1 = homeTeamScore1;
        }
        public int getAwayTeamScore1() {
                return awayTeamScore1;
        }
        public void setAwayTeamScore1(int awayTeamScore1) {
                this.awayTeamScore1 = awayTeamScore1;
        }
        public double getHomeTeamScore2() {
                return homeTeamScore2;
        }
        public void setHomeTeamScore2(double homeTeamScore2) {
                this.homeTeamScore2 = homeTeamScore2;
        }
        public double getAwayTeamScore2() {
                return awayTeamScore2;
        }
        public void setAwayTeamScore2(double awayTeamScore2) {
                this.awayTeamScore2 = awayTeamScore2;
        }
        public String homeTeamScore() {
                return getHomeTeamScore2()+"("+getHomeTeamScore1()+")";
        }
        public String awayTeamScore() {
                return getAwayTeamScore2()+"("+getAwayTeamScore1()+")";
        }
        public static Scanner sc=new Scanner(System.in);
        public static String input1() {
                System.out.print("Which team scored?");
                String str=sc.nextLine();
                if(!(str.equals("h") || str.equals("a") || str.equals("f"))) {
                        System.out.println("Invalid input!");
                        input1();
                }
                
                return str;
        }
        public static String input2() {
                System.out.print("Goal or behind?");
                String str=sc.nextLine();
                if(!(str.equals("g") || str.equals("b"))) {
                        System.out.println("Invalid input!");
                        input2();
                }
                
                return str;
        }
        //MAIN()//
        public static void main(String args[]) {
                if(args.length!=2) {
                        System.out.println("Invalid number of arguments!");
                        return;
                }
                String homeFilename,awayFilename;
                homeFilename=args[0];
                awayFilename=args[1];
                
                String teamName,coachName;
                AFLPlayer lineup[]=new AFLPlayer[22];
                AFLTeam homeTeam,awayTeam;
                AFLMatch aflmatch;
                
                try {
                        BufferedReader homeBr=new BufferedReader(new FileReader(new File(homeFilename)));
                        BufferedReader awayBr=new BufferedReader(new FileReader(new File(awayFilename)));
                        String str;
                        //reading data for home team//
                        teamName=homeBr.readLine();
                        str=homeBr.readLine();
                        coachName=str.split(",")[0];
                        int num=0;
                        while((str=homeBr.readLine())!=null){
                                String arr[]=str.split(",");
                                if(arr.length==4)
                                        lineup[num++]=new AFLPlayer(arr[1],arr[2],Integer.parseInt(arr[0]),true);
                                else
                                        lineup[num++]=new AFLPlayer(arr[1],arr[2],Integer.parseInt(arr[0]),false);
                        }
                        homeTeam=new AFLTeam(teamName,new AFLTeamMember(coachName,"COACH"),lineup);
                        
                        //reading data for away team//
                        teamName=awayBr.readLine();
                        str=awayBr.readLine();
                        coachName=str.split(",")[0];
                        num=0;
                        while((str=awayBr.readLine())!=null){
                                String arr[]=str.split(",");
                                if(arr.length==4)
                                        lineup[num++]=new AFLPlayer(arr[1].trim(),arr[2].trim(),Integer.parseInt(arr[0]),true);
                                else
                                        lineup[num++]=new AFLPlayer(arr[1].trim(),arr[2].trim(),Integer.parseInt(arr[0]),false);
                        }
                        awayTeam=new AFLTeam(teamName,new AFLTeamMember(coachName,"COACH"),lineup);
                        aflmatch=new AFLMatch(homeTeam,awayTeam);
                        //playing the game//
                        while(true) {
                                String teamScore=input1();
                                if(teamScore.equals("f")) {
                                        System.out.println("FULL TIME");
                                        break;
                                }
                                String goalOrBehind=input2();
                                
                                if(teamScore.equals("h")) {
                                        if(goalOrBehind.equals("g")) {
                                                aflmatch.setHomeTeamScore1(aflmatch.getHomeTeamScore1()+6);
                                                aflmatch.setHomeTeamScore2(aflmatch.getHomeTeamScore2()+1.0);
                                        }else {
                                                aflmatch.setHomeTeamScore1(aflmatch.getHomeTeamScore1()+1);
                                                aflmatch.setHomeTeamScore2(aflmatch.getHomeTeamScore2()+0.1);
                                        }
                                }else {
                                        if(goalOrBehind.equals("g")) {
                                                aflmatch.setAwayTeamScore1(aflmatch.getAwayTeamScore1()+6);
                                                aflmatch.setAwayTeamScore2(aflmatch.getAwayTeamScore2()+1.0);
                                        }else {
                                                aflmatch.setAwayTeamScore1(aflmatch.getAwayTeamScore1()+1);
                                                aflmatch.setAwayTeamScore2(aflmatch.getAwayTeamScore2()+0.1);
                                        }
                                }
                                
                                System.out.print("The current score is ");
                                System.out.print(aflmatch.homeTeamScore());
                                System.out.println(" to "+aflmatch.awayTeamScore());
                        }
                        
                        if(aflmatch.getHomeTeamScore1()>aflmatch.getAwayTeamScore1())
                                System.out.println(aflmatch.getHomeTeam().getName()+" "+aflmatch.homeTeamScore()+" defeats "+aflmatch.getAwayTeam().getName()+" "+aflmatch.awayTeamScore());
                        else if(aflmatch.getHomeTeamScore1()<aflmatch.getAwayTeamScore1())
                                System.out.println(aflmatch.getAwayTeam().getName()+" "+aflmatch.awayTeamScore()+" defeats "+aflmatch.getHomeTeam().getName()+" "+aflmatch.homeTeamScore());
                        else {
                                if(aflmatch.getHomeTeamScore2()>aflmatch.getAwayTeamScore2())
                                        System.out.println(aflmatch.getHomeTeam().getName()+" "+aflmatch.homeTeamScore()+" defeats "+aflmatch.getAwayTeam().getName()+" "+aflmatch.awayTeamScore());
                                else if(aflmatch.getHomeTeamScore2()<aflmatch.getAwayTeamScore2())
                                        System.out.println(aflmatch.getAwayTeam().getName()+" "+aflmatch.awayTeamScore()+" defeats "+aflmatch.getHomeTeam().getName()+" "+aflmatch.homeTeamScore());
                                else
                                        System.out.println(aflmatch.getAwayTeam().getName()+" "+aflmatch.awayTeamScore()+" drew with "+aflmatch.getHomeTeam().getName()+" "+aflmatch.homeTeamScore());
               
                        }
                        sc.close();
                } catch (Exception e) {
                        System.out.println(e+"Invalid filename or file not found!");
                }
                
                
        }
}
//end of AFLMatch.java//

