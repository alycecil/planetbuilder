public class Build {
    static String build(int root_alicemod_orbit_angle_offset, int root_alicemod_orbit_distance_offset, final String planet_class) {
        return new StringBuilder()
                .append("\t\t\tsolar_system = {\n")
                .append("\t\t\t\tspawn_planet = {\n")
                .append("\t\t\t\t\tclass = " + planet_class + "\n")
                .append("\t\t\t\t\tlocation = root\n")
                .append("\t\t\t\t\torbit_location = yes\n")
                .append("\t\t\t\t\torbit_angle_offset = ")
                .append(root_alicemod_orbit_angle_offset)
                .append("\n")
                .append("\t\t\t\t\torbit_distance_offset = ")
                .append(root_alicemod_orbit_distance_offset)
                .append("\n")
                .append("\t\t\t\t\tsize = 4\n")
                .append("\t\t\t\t\thas_ring = no\n")
                .append("\n")
                .append("\t\t\t\t\tinit_effect = {\n")
                .append("\t\t\t\t\t\tset_name = \"Habitat\" \n")
                .append("\t\t\t\t\t\tset_planet_entity = { entity = \"habitat_phase_01_entity\" graphical_culture = root }\n")
                .append("\t\t\t\t\t\tset_planet_size = 4\n")
                .append("\t\t\t\t\t\tset_planet_flag = megastructure\n")
                .append("\t\t\t\t\t\tset_planet_flag = habitat\n")
                .append("\t\t\t\t\t\tset_planet_flag = new_habitat\n")
                .append("\t\t\t\t\t}\n")
                .append("\t\t\t\t}\n")
                .append("\t\t\t}").toString();
    }

    public static void main(String[] args) {
        int count = 3;
        double degrees = 360.0 / count;
        double degrees_current = 0;
        int distance = 25;
        for (int i = 0; i < count; i++) {
            distance++;
            degrees_current += degrees;

            StringBuilder s = new StringBuilder().append(i == 0 ? ("\t\tif = {\n") : ("\t\telse_if = {\n")).append("\t\t\tlimit = { check_variable = {\n").append("\t\t\t\t\twhich = alicemod_orbit_happened\n").append("\t\t\t\t\tvalue <= ").append(i + 1).append("\n").append("\t\t\t}\t}\n");
            s.append(build((int) Math.round(degrees_current), distance, "pc_habitat"));
            s.append("\n\t\t}");

            System.out.println(s.toString());
        }
    }
}
