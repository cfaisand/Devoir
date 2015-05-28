import java.io.*;

public class TestTerrainconstructible {

	public static void main(String args[]){

		TerrainConstructible t1 = new TerrainConstructible();
		TerrainConstructible t2 = new TerrainConstructible();

		t1.init();

		try {
			t1.sauvegarderTerrain("terrain.txt");
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		try{
			t2.chargerTerrain("terrain.txt");
		}
		catch(IOException e){
			System.out.println(e);
		}
		

		System.out.println(t2.toString());


	}
}