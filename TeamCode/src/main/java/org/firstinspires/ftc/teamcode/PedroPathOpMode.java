package org.firstinspires.ftc.teamcode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public static class Paths {
    public PathChain Path1;
    public PathChain Path2;
    public PathChain Path3;
    public PathChain Path4;
    public PathChain Path5;
    public PathChain Path6;
    public PathChain Path7;

    public Paths(Follower follower) {
        Path1 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(56.000, 8.000),
                                new Pose(47.500, 25.000),
                                new Pose(35.120, 36.000)
                        )
                )
                .setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(180))
                .build();

        Path2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(35.120, 36.000),
                                new Pose(15.000, 36.000)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Pose(15.000, 36.000),
                                new Pose(72.176, 71.904)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(135))
                .build();

        Path4 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(72.176, 71.904),
                                new Pose(44.120, 57.920),
                                new Pose(14.784, 59.712)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path5 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(14.784, 59.712),
                                new Pose(47.340, 59.616),
                                new Pose(72.280, 71.664)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(135))
                .build();

        Path6 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(72.280, 71.664),
                                new Pose(46.840, 86.116),
                                new Pose(14.152, 83.816)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

        Path7 = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Pose(14.152, 83.816),
                                new Pose(47.592, 85.764),
                                new Pose(71.976, 71.904)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(135))
                .build();
    }
}