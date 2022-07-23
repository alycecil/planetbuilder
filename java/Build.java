public class Build {
    static String build(int root_alicemod_orbit_angle_offset, int root_alicemod_orbit_distance_offset, final String planet_class) {
        if ("pc_ringworld_seam".equals(planet_class)) {
            return new StringBuilder().append("spawn_planet = {\n" +
                    "                class = \"pc_ringworld_seam\"\n" +
                    "                location = root\n" +
                    "                orbit_location = yes\n")
                    .append("\t\t\t\t\torbit_angle_offset = ")
                    .append(root_alicemod_orbit_angle_offset)
                    .append("\n")
                    .append("\t\t\t\t\torbit_distance_offset = ")
                    .append(root_alicemod_orbit_distance_offset)
                    .append("\n                size = 10\n")
                    .append("                has_ring = no\n")
                    .append("\n").append("                init_effect = {\n")
                    .append("                    set_name = \"NAME_Ring_Section\"\n")
                    .append("                    set_planet_entity = {\n")
                    .append("                        entity = \"ringworld_seam_entity_01_entity\"\n")
                    .append("                        graphical_culture = owner\n")
                    .append("                    }\n")
                    .append("                    set_all_comms_surveyed = yes\n")
                    .append("                    clear_blockers = yes\n")
                    .append("                    save_event_target_as = ring_section\n")
                    .append("                    trigger_megastructure_icon = yes\n")
                    .append("                    set_planet_flag = megastructure\n")
                    .append("                }\n")
                    .append("            }\n").toString();
        } else if ("pc_ringworld_habitable".equals(planet_class)) {
            return new StringBuilder().append(
                    "            spawn_planet = {\n" +
                            "                class = \"pc_ringworld_habitable\"\n" +
                            "                location = root\n" +
                            "                orbit_location = yes\n")
                    .append("\t\t\t\t\torbit_angle_offset = ")
                    .append(root_alicemod_orbit_angle_offset)
                    .append("\n")
                    .append("\t\t\t\t\torbit_distance_offset = ")
                    .append(root_alicemod_orbit_distance_offset)
                    .append(
                            "\n                size = 10\n" +
                                    "                has_ring = no\n" +
                                    "\n" +
                                    "                init_effect = {\n" +
                                    "                    set_name = \"NAME_Habitable_Section_A\"\n" +
                                    "                    set_planet_entity = {\n" +
                                    "                        entity = \"ringworld_habitable_entity_01_entity\"\n" +
                                    "                        graphical_culture = owner\n" +
                                    "                    }\n" +
                                    "                    set_all_comms_surveyed = yes\n" +
                                    "                    clear_blockers = yes\n" +
                                    "                    save_event_target_as = ring_section\n" +
                                    "                    trigger_megastructure_icon = yes\n" +
                                    "                    set_planet_flag = megastructure\n" +
                                    "                }\n" +
                                    "            }\n").toString();
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
        String whichVar = "alicemod_orbit_ring_happened_outer";
        int count = 16;
        double degrees = 360.0 / count;
        double degrees_current = 0;
        int distance = 55;
        for (int i = 0; i < count; i++) {
            String whichKind;
            if (i % 4 == 0) {
                whichKind = pc.pc_ringworld_habitable.name();
            } else {
                whichKind = pc.pc_ringworld_seam.name();
            }
            //distance++;
            degrees_current += degrees;

            StringBuilder s = new StringBuilder();
//                    .append(i == 0 ? ("\t\tif = {\n") : ("\t\telse_if = {\n"))
//                    .append("\t\t\tlimit = { check_variable = {\n")
//                    .append("\t\t\t\t\twhich = " + whichVar + "\n")
//                    .append("\t\t\t\t\tvalue <= ").append(i + 1).append("\n")
//                    .append("\t\t\t}\t}\n");
            s.append(build((int) Math.round(degrees_current), distance, whichKind));
//            s.append("\n\t\t}");

            System.out.println(s.toString());
        }
    }
}

enum pc {
    pc_ringworld_habitable,
    pc_ringworld_seam,
    pc_habitat
}