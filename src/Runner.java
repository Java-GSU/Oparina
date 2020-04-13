import by.gsu.pms.Materials;
import by.gsu.pms.Subject;

public class Runner {
    public static void main(String[] args) {
        Materials STEEL = Materials.STEEL;
        Subject wire = new Subject("wire", STEEL, 0.03);
        System.out.println(wire);

        Materials COOPER = Materials.COOPER;
        wire.setMaterials(COOPER);
        System.out.println("The wire mass is " + wire.getMass() + " kg.");

    }
}
