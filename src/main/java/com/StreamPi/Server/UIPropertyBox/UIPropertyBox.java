package com.StreamPi.Server.UIPropertyBox;

import com.StreamPi.ActionAPI.ActionProperty.Property.ControlType;
import com.StreamPi.ActionAPI.ActionProperty.Property.Type;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class UIPropertyBox
{
    private Node controlNode;
    private boolean canBeBlank;
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public boolean isCanBeBlank() {
        return canBeBlank;
    }

    private int index;

    private ControlType controlType;
    private Type type;

    public UIPropertyBox(int index, String displayName, Node controlNode, ControlType controlType, Type type, boolean canBeBlank)
    {
        this.index = index;
        this.displayName = displayName;
        this.controlNode = controlNode;
        this.controlType = controlType;
        this.type = type;
        this.canBeBlank = canBeBlank;
    }

    public ControlType getControlType()
    {
        return controlType;
    }

    public Node getControlNode()
    {
        return controlNode;
    }

    public int getIndex() {
        return index;
    }

    public Type getType()
    {
        return type;
    }

    public String getRawValue()
    {
        String rawValue = null;

        if (controlType == ControlType.TEXT_FIELD)
            rawValue = ((TextField) controlNode).getText();
        else if (controlType == ControlType.COMBO_BOX)
            rawValue = ((ComboBox<String>) controlNode).getSelectionModel().getSelectedIndex() + "";
        else if (controlType == ControlType.SLIDER_DOUBLE)
            rawValue = ((Slider) controlNode).getValue() + "";
        else if (controlType == ControlType.SLIDER_INTEGER)
            rawValue = Math.round(((Slider) controlNode).getValue()) + "";
        else if (controlType == ControlType.TOGGLE) {
            ToggleButton toggleButton = ((ToggleButton) controlNode);
            if (toggleButton.isSelected())
                rawValue = "true";
            else
                rawValue = "false";
        }

        return rawValue;
    }
}