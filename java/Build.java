public class Build {
    static String build(int root_alicemod_orbit_angle_offset, int root_alicemod_orbit_distance_offset, final String planet_class) {
        if ("pc_ringworld_seam".equals(planet_class)) {
            return new StringBuilder()
                    .append("\t\t\tsolar_system = {\n")
                    .append("\t\t\t\tspawn_planet = {\n" +
                    "\t\t\t\t\tclass = \"pc_ringworld_seam\"\n" +
                    "\t\t\t\t\tlocation = root\n" +
                    "\t\t\t\t\torbit_location = yes\n")
                    .append("\t\t\t\t\torbit_angle_offset = ")
                    .append(root_alicemod_orbit_angle_offset)
                    .append("\n")
                    .append("\t\t\t\t\torbit_distance_offset = ")
                    .append(root_alicemod_orbit_distance_offset)
                    .append("\t\n")
                    .append("\t\t\t\t\tsize = 10\n")
                    .append("\t\t\t\t\thas_ring = no\n")
                    .append("\n").append("\t\t\t\t\tinit_effect = {\n")
                    .append("\t\t\t\t\t\tset_name = \"NAME_Ring_Section\"\n")
                    .append("\t\t\t\t\t\tset_planet_entity = {\n")
                    .append("\t\t\t\t\t\t\tentity = \"ringworld_seam_entity_01_entity\"\n")
                    .append("\t\t\t\t\t\t\tgraphical_culture = owner\n")
                    .append("\t\t\t\t\t\t}\n")
                    .append("\t\t\t\t\t\tset_all_comms_surveyed = yes\n")
                    .append("\t\t\t\t\t\tclear_blockers = yes\n")
                    .append("\t\t\t\t\t\tsave_event_target_as = ring_section\n")
                    .append("\t\t\t\t\t\ttrigger_megastructure_icon = yes\n")
                    .append("\t\t\t\t\t\tset_planet_flag = megastructure\n")
                    .append("\t\t\t\t\t}\n")
                    .append("\t\t\t\t}\n")
                    .append("\t\t\t}")
                    .toString();
        } else if ("pc_ringworld_habitable".equals(planet_class)) {
            return new StringBuilder()

                    .append("\t\t\tsolar_system = {\n")
                    .append(
                    "\t\t\t\tspawn_planet = {\n" +
                            "\t\t\t\t\tclass = \"pc_ringworld_habitable\"\n" +
                            "\t\t\t\t\tlocation = root\n" +
                            "\t\t\t\t\torbit_location = yes\n")
                    .append("\t\t\t\t\torbit_angle_offset = ")
                    .append(root_alicemod_orbit_angle_offset)
                    .append("\n")
                    .append("\t\t\t\t\torbit_distance_offset = ")
                    .append(root_alicemod_orbit_distance_offset)
                    .append(
                            "\n" +
                                    "\t\t\t\t\tsize = 10\n" +
                                    "\t\t\t\t\thas_ring = no\n" +
                                    "\n" +
                                    "\t\t\t\t\tinit_effect = {\n" +
                                    "\t\t\t\t\t\tset_name = \"NAME_Habitable_Section_A\"\n" +
                                    "\t\t\t\t\t\tset_planet_entity = {\n" +
                                    "\t\t\t\t\t\t\tentity = \"ringworld_habitable_entity_01_entity\"\n" +
                                    "\t\t\t\t\t\t\tgraphical_culture = owner\n" +
                                    "\t\t\t\t\t\t}\n" +
                                    "\t\t\t\t\t\tset_all_comms_surveyed = yes\n" +
                                    "\t\t\t\t\t\tclear_blockers = yes\n" +
                                    "\t\t\t\t\t\tsave_event_target_as = ring_section\n" +
                                    "\t\t\t\t\t\ttrigger_megastructure_icon = yes\n" +
                                    "\t\t\t\t\t\tset_planet_flag = megastructure\n" +
                                    "\t\t\t\t\t}\n" +
                                    "\t\t\t\t}\n")
                    .append("\t\t\t}")
                    .toString();
        }

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
        String whichVar = "alicemod_outer_orbit_happened_2";
        int count = 4*16*3;
        double degrees = 360.0 / count;
        double degrees_current = 0;
        int distance = 450;
        int times = 0;
        for (int i = 0; i < count; i++) {
            String whichKind;
            boolean breakPoint = i % 4 == 0;
            if (breakPoint) {
                whichKind = pc.pc_ringworld_habitable.name();
            } else {
                whichKind = pc.pc_ringworld_seam.name();
            }
            //distance++;
            degrees_current += degrees;

            StringBuilder s = new StringBuilder();

            if (
                    breakPoint
            ) {
                s.append(times == 0 ? ("\t\tif = {\n") : ("\n\t\t}\n\t\telse_if = {\n"))
                        .append("\t\t\tlimit = { check_variable = {\n")
                        .append("\t\t\t\t\twhich = " + whichVar + "\n")
                        .append("\t\t\t\t\tvalue <= ").append(times + 1).append("\n")
                        .append("\t\t\t}\t}\n");
                times++;
            }

            s.append(build((int) Math.round(degrees_current), distance, whichKind));

            System.out.println(s.toString());
        }

    }
}

enum pc {
    pc_ringworld_habitable,
    pc_ringworld_seam,
    pc_habitat
}