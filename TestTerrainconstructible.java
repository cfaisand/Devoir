public class TestTerrainConstructible {

	public static void main(String args[]){

		TerrainConstructible t1 = new TerrainConstructible();
		TerrainConstructible t2 = new TerrainConstructible();

		t1.init();

		try {
			t1.sauvegarderTerrain("terrain.txt");
		}
		catch (IOException e){
			System.out.println(e);
		}
		

		t2.chargerTerrain("terrain.txt");

		System.out.println(t2.toString());


	}
}