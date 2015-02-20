
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.*;
 import java.util.ArrayList;


public class mazeWithFileInput {


   public static void main(String[] args) {
   
   
	Scanner in = new Scanner(System.in);
   
    System.out.println("Enter the dimension of maze");
	int m=in.nextInt();
	int n=in.nextInt();
	System.out.println("\n\nEnter the maze in a text file and rename it to maze.txt.\nPut it in same directory as mazeWithFileInput.class file.\nRerun this program.\n\nLegend:\n\n-	Empty Block\n#	Obstacle\nS	Start\nE	End\n\n\n");	
	int sx=0,sy=0,ex=0,ey=0;
	//in.nextLine();// taking in stray string
	
	//String s = new String();
	int[][] maze = new int[m][n];

  

    String file ="maze.txt";
    try {
	
			InputStream ips=new FileInputStream(file); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
    
			String s;
			int i=0;
            while ((s=br.readLine())!=null){
						s=s.replaceAll("\\s","");
						for(int j=0;j<n;j++){
												char t=Character.valueOf(s.charAt(j));
												if(t=='S'){sx=i;sy=j;maze[i][j]=0;}
												if(t=='E'){ex=i;ey=j;maze[i][j]=-3;}
												if(t=='-'){maze[i][j]=-1;}
												if(t=='#'){maze[i][j]=-2;}
												}
						i++;
						 
            }
            br.close(); 
        }       
        catch (Exception e){
            System.out.println(e.toString());
        }
		
		

    ArrayList<int[]> action = new ArrayList<int[]>();
	int[] po = new int[]{sx,sy};
	action.add( po);
	
	for(;;){
	int[] ho = new int[2];
	ho=action.get(0);
	int x=ho[0];
	int y=ho[1];
	int value = maze[x][y];
	
	action.remove(0);
	if(x-1>=0&&maze[x-1][y]==-1){
							maze[x-1][y]=value+1;
							po=new int[]{x-1,y};
							action.add(po);
							}
	else if(x-1>=0&&maze[x-1][y]==-3){maze[x-1][y]=value+1;break;}
	
	
	if(x-1>=0&&y+1<n&&maze[x-1][y+1]==-1){
							maze[x-1][y+1]=value+1;
							po=new int[]{x-1,y+1};
							action.add(po);
							}
	else if(x-1>=0&&y+1<n&&maze[x-1][y+1]==-3){maze[x-1][y+1]=value+1;break;}
	
	
	if(y+1<n&&maze[x][y+1]==-1){
							maze[x][y+1]=value+1;
							po=new int[]{x,y+1};
							action.add(po);
							}
	else if(y+1<n&&maze[x][y+1]==-3){maze[x][y+1]=value+1;break;}
	
	
	if(x+1<m&&y+1<n&&maze[x+1][y+1]==-1){
							maze[x+1][y+1]=value+1;
							po=new int[]{x+1,y+1};
							action.add(po);
							}
	else if(x+1<m&&y+1<n&&maze[x+1][y+1]==-3){maze[x+1][y+1]=value+1;break;}
	
	
	if(x+1<m&&maze[x+1][y]==-1){
							maze[x+1][y]=value+1;
							po=new int[]{x+1,y};
							action.add(po);
							}
	else if(x+1<m&&maze[x+1][y]==-3){maze[x+1][y]=value+1;break;}
	
	
	if(x+1<m&&y-1>=0&&maze[x+1][y-1]==-1){
							maze[x+1][y-1]=value+1;
							po=new int[]{x+1,y-1};
							action.add(po);
							}
	else if(x+1<m&&y-1>=0&&maze[x+1][y-1]==-3){maze[x+1][y-1]=value+1;break;}
	
	
	if(y-1>=0&&maze[x][y-1]==-1){
							maze[x][y-1]=value+1;
							po=new int[]{x,y-1};
							action.add(po);
							}
	else if(y-1>=0&&maze[x][y-1]==-3){maze[x][y-1]=value+1;break;}
	
	
	if(x-1>=0&&y-1>=0&&maze[x-1][y-1]==-1){
							maze[x-1][y-1]=value+1;
							po=new int[]{x-1,y-1};
							action.add(po);
							}
	else if(x-1>=0&&y-1>=0&&maze[x-1][y-1]==-3){maze[x-1][y-1]=value+1;break;}
	//System.out.printf("hoo"+ho[0]+"  "+ho[1]);}
	
    					
    }	
	
	
	System.out.println("\n");
	
	
	
						  
						 
	int plen=maze[ex][ey];
	//System.out.printf("\nplen= "+plen);
	int x=ex,y=ey;
	for(int i=plen;i>=1;i--){
							  maze[x][y]=-4;//-4 translates to P
							if(x-1>=0&&maze[x-1][y]==i-1){
													x=x-1;y=y;
													}
							
							
							
							else if(x-1>=0&&y+1<n&&maze[x-1][y+1]==i-1){
													x=x-1;y=y+1;
													}
							
							
							
							else if(y+1<n&&maze[x][y+1]==i-1){
													x=x;y++;
													}
							
							
							
							else if(x+1<m&&y+1<n&&maze[x+1][y+1]==i-1){
													x++;y++;
													}
							
							
							
							else if(x+1<m&&maze[x+1][y]==i-1){
													x++;
													}
							
							
							
							else if(x+1<m&&y-1>=0&&maze[x+1][y-1]==i-1){
													x++;y--;
													}
							
							
							
							else if(y-1>=0&&maze[x][y-1]==i-1){
													y--;
													}
							
							
							
							else if(x-1>=0&&y-1>=0&&maze[x-1][y-1]==i-1){
													x--;y--;
													}
							
						}
						

	
	System.out.printf("Shortest path is:\n\n");
	for(int i=0;i<m;i++){
						  for(int j=0;j<n;j++){
												if(maze[i][j]==-1)System.out.printf("-"+"  ");
												else if(maze[i][j]==-2)System.out.printf("#"+"  ");
												else if(i==ex&&j==ey)System.out.printf("E"+"  ");
												else if(i==sx&&j==sy)System.out.printf("S"+"  ");
												else if(maze[i][j]==-4)System.out.printf("P"+"  ");
												else System.out.printf("-"+"  ");
												}
						  System.out.printf("\n\n");
						  }
								
					  
    //writing
	String fileout="path.txt";
        try {
            FileWriter fw = new FileWriter (fileout);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter fileOut = new PrintWriter (bw); 
               
            
			for(int i=0;i<m;i++){
						  for(int j=0;j<n;j++){
												if(maze[i][j]==-1)fileOut.printf("-"+"  ");
												else if(maze[i][j]==-2)fileOut.printf("#"+"  ");
												else if(i==ex&&j==ey)fileOut.printf("E"+"  ");
												else if(i==sx&&j==sy)fileOut.printf("S"+"  ");
												else if(maze[i][j]==-4)fileOut.printf("P"+"  ");
												else fileOut.printf("-"+"  ");
												}
						  fileOut.println("\n\n");
						  }
			fileOut.close();
            System.out.println("\n\nThe file " + fileout + " is created in same directory!"); 
        }
        catch (Exception e){
            System.out.println(e.toString());
        }     
  }
}