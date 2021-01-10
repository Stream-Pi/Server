package com.StreamPi.Server.Window.FirstTimeUse;

import com.StreamPi.Server.Info.License;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LicensePane extends VBox {
    public LicensePane()
    {
        getStyleClass().add("first_time_use_pane_license");

        Label label = new Label("By Clicking on 'Next', you agree with the license of StreamPi, and the license(s) of the library(s) used/included with this software.");
        label.prefWidthProperty().bind(widthProperty());
        label.setWrapText(true);

        TextArea licenseTextArea = new TextArea(License.getLicense());
        licenseTextArea.setWrapText(false);
        licenseTextArea.setEditable(false);

        licenseTextArea.prefWidthProperty().bind(widthProperty());
        VBox.setVgrow(licenseTextArea, Priority.ALWAYS);

        getChildren().addAll(label, licenseTextArea);
    }
}
