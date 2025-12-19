package org.noname.fantasy_weapons_mod.util;

import net.minecraft.world.phys.Vec3;

public class VectorCalculations {

    /**
     * Uses the dot product to determine if vector
     * a is behind vector b. Vector a is considered
     * behind vector b if the dot product of a and b is
     * greater than or equal to 0.8. A dot product of 1 means the two
     * vectors are facing the exact same direction, so we give some margin.
     *
     * When you use this method, pass in normalized direction vectors.
     *
     * @param a A vector. Use the normalized form of a vector between
     *         two points. The vector from V1 to V2 is gotten from V2 - V1.
     * @param b A vector. Use the normalized forward direction of
     *         your destination point.
     * @return If Vector a is behind vector b
     */
    public static boolean behind(Vec3 a, Vec3 b) {
        return a.dot(b) >= 0.8;
    }
}
