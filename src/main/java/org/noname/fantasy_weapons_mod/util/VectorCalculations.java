package org.noname.fantasy_weapons_mod.util;

import net.minecraft.world.phys.Vec3;

public class VectorCalculations {

    /**
     * Uses the dot product to determine if vector
     * lineAToB is behind vector bDirection. Vector lineAToB is considered
     * behind vector bDirection if the dot product of lineAToB and bDirection is
     * greater than or equal to 0.8. A dot product of 1 means the two
     * vectors are facing the exact same direction, so we give some margin.
     *
     * When you use this method, pass in normalized direction vectors.
     *
     * @param lineAToB A vector. Use the normalized form of lineAToB vector between
     *         two points. The vector from V1 to V2 is gotten from V2 - V1.
     * @param bDirection A vector. Use the normalized forward direction of
     *         your destination point.
     * @return If Vector lineAToB is behind vector bDirection
     */
    public static boolean behind(Vec3 lineAToB, Vec3 bDirection) {
        return lineAToB.dot(bDirection) >= 0.8;
    }
}
