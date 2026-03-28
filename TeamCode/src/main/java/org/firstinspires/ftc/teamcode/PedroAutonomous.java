package org.firstinspires.ftc.teamcode;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.bylazar.configurables.annotations.Configurable;
import com.bylazar.telemetry.TelemetryManager;
import com.bylazar.telemetry.PanelsTelemetry;
import pedroPathing.Constants;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;
import com.pedropathing.geometry.Pose;

@Autonomous(name = "Pedro Pathing Autonomous", group = "Autonomous")
@Configurable // Panels
public class PedroAutonomous extends OpMode {
    private TelemetryManager panelsTelemetry; // Panels Telemetry instance
    public Follower follower; // Pedro Pathing follower instance
    private int pathState; // Current autonomous path state (state machine)
    private Paths PedroPathAutonomous; // Paths defined in the Paths class

    @Override
    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();

        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(72, 8, Math.toRadians(90)));

        PedroPathAutonomous = new Paths(follower); // Build paths

        panelsTelemetry.debug("Status", "Initialized");
        panelsTelemetry.update(telemetry);
    }

    @Override
    public void loop() {
        follower.update(); // Update Pedro Pathing
        pathState = autonomousPathUpdate(); // Update autonomous state machine

        // Log values to Panels and Driver Station
        panelsTelemetry.debug("Path State", pathState);
        panelsTelemetry.debug("X", follower.getPose().getX());
        panelsTelemetry.debug("Y", follower.getPose().getY());
        panelsTelemetry.debug("Heading", follower.getPose().getHeading());
        panelsTelemetry.update(telemetry);
    }

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

    public int autonomousPathUpdate() {
        switch (pathState) {
            case 0:
                follower.followPath(PedroPathAutonomous.Path1);
                pathState = 1;
                break;
            case 1:
                if (!follower.isBusy()) {
                    follower.followPath(PedroPathAutonomous.Path2);
                    pathState = 2;
                }
                break;
            case 2:
                if (!follower.isBusy()) {
                    follower.followPath(PedroPathAutonomous.Path3);
                    pathState = 3;
                }
                break;
            case 3:
                if (!follower.isBusy()) {
                    follower.followPath(PedroPathAutonomous.Path4);
                    pathState = 4;
                }
                break;
            case 4:
                if (!follower.isBusy()) {
                    follower.followPath(PedroPathAutonomous.Path5);
                    pathState = 5;
                }
                break;
            case 5:
                if (!follower.isBusy()) {
                    follower.followPath(PedroPathAutonomous.Path6);
                    pathState = 6;
                }
                break;
            case 6:
                if (!follower.isBusy()) {
                    follower.followPath(PedroPathAutonomous.Path7);
                    pathState = 7;
                }
                break;
            case 7:
                break;
        }
        return pathState;
    }
}