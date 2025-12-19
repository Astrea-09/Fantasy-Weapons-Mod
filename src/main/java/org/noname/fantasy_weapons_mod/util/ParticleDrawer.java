package org.noname.fantasy_weapons_mod.util;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;

public class ParticleDrawer {

    static class Tracer {

        /**
         * Traces a line between two vectors.
         *
         * <p>P.S.: This came to me surprisingly quickly, and I'm so glad
         * I finally figured out how to do this.</p>
         *
         * @param start The starting vector.
         * @param end The ending vector.
         * @param iterations The number of steps to trace between start and end.
         * @return An ArrayList of points along the traced line. The ArrayList size will
         * match iterations.
         */
        public static ArrayList<Vec3> traceBetweenVectors(Vec3 start, Vec3 end, int iterations) {
            ArrayList<Vec3> points = new ArrayList<>(); // Will be filled with points between start and end

            Vec3 startToEnd = end.subtract(start); // The vector representing a straight line from start to end

            double magnitude = startToEnd.length(); // The length of the startToEnd vector. Essentially a distance.
            double increment = magnitude / iterations; // The size of the step to take between each trace

            Vec3 currentPosition = start; // The current position we are along the startToEnd vector

            // Essentially just step along the startToEnd vector
            // Each point generated will be directly on startToEnd
            for(double i = 0; i < magnitude; i += increment) {
                // Preserve the direction of startToEnd by normalizing it, but also scale it down
                // to the size of an incremental step so that we always have positions on the
                // startToEnd vector
                currentPosition = currentPosition.add(startToEnd.normalize().scale(increment));
                points.add(currentPosition);
            }

            return points;
        }

        /**
         * Traces a circle around a point
         *
         * @param center The center point
         * @param radius The radius of the circle
         * @param iterations The number of steps to trace around center
         * @return An ArrayList of points in a circle around center
         */
        public static ArrayList<Vec3> traceCircleAroundVector(Vec3 center, double radius, int iterations) {
            ArrayList<Vec3> points = new ArrayList<>(); // Will be filled with points around the center

            int step = 360 / iterations; // Use 360 since that's a full circle and I don't know
                                         // if the 90-degree circle drawing oddity applies here
            for(int i = 0; i < iterations; i += step) {
                // Multiply cos(i) and sin(i) by radius since normally (cos(theta), sin(theta)) create a circle of radius 1
                double x = center.x() + (Math.cos(i) * radius); // Standard definition x = cos(theta)
                double z = center.z() + (Math.sin(i) * radius); // Swap y for z in standard definition, now z = sin(theta)


                points.add(new Vec3(x, center.y(), z));
            }

            return points;
        }
    }

    /**
     * Draws a line of particles between two points
     *
     * @param level The world to draw the line in
     * @param particle The particle that will be spawned
     * @param start The starting point
     * @param end The end point
     * @param iterations The number of steps between start and end
     */
    public static void drawLineBetweenPoints(ServerLevel level, ParticleOptions particle, Vec3 start, Vec3 end, int iterations) {
        ArrayList<Vec3> points = Tracer.traceBetweenVectors(start, end, iterations);

        for(Vec3 point : points) {
            level.sendParticles(particle, point.x(), point.y(), point.z(), 2,
                    0, 0, 0, 0.05);
        }
    }

    /**
     * Draws a line between two entities
     *
     * @param level The world to draw the line
     * @param particle The particle to draw
     * @param startingEntity The entity to start the line at
     * @param endingEntity The entity to end the line at
     * @param iterations The number of steps between startingEntity and endingEntity
     */
    public static void drawLineBetweenPoints(ServerLevel level, ParticleOptions particle, Entity startingEntity, Entity endingEntity, int iterations) {
        drawLineBetweenPoints(level, particle, startingEntity.position(), endingEntity.position(), iterations);
    }

    /**
     * Draws a circle around a point
     *
     * @param level The world to draw the circle in
     * @param particle The particle that will be drawn
     * @param center The center of the circle
     * @param radius The radius of the circle
     * @param amount The number of particles to spawn at each drawing step
     * @param speed The speed of the particles (Usually something like 0.05)
     */
    public static void drawCircle(ServerLevel level, ParticleOptions particle, Vec3 center, double radius, int amount, double speed) {
        for(int i = 1; i <= 90; i++) { // For some reason 90 degrees is all you need to draw the full circle
            // Multiply cos(i) and sin(i) by radius since normally (cos(theta), sin(theta)) create a circle of radius 1
            float x = (float) (center.x() + (Math.cos(i) * radius)); // Standard definition x = cos(theta)
            float z = (float) (center.z() + (Math.sin(i) * radius)); // Swap y for z in standard definition, now z = sin(theta)

            level.sendParticles(particle, x, center.y(), z, amount,
                    0, 0, 0, speed);
        }
    }

    /**
     * Draws a circle around an entity
     *
     * @param level The world to draw the circle in
     * @param particle The particle to draw
     * @param centerEntity The entity at the center of the circle
     * @param radius The radius of the circle
     * @param amount The number of particles to draw at each drawing step
     * @param speed The speed of the particles (Usually something like 0.05)
     */
    public static void drawCircle(ServerLevel level, ParticleOptions particle, Entity centerEntity, double radius, int amount, double speed) {
        drawCircle(level, particle, centerEntity.position(), radius, amount, speed);
    }
}
