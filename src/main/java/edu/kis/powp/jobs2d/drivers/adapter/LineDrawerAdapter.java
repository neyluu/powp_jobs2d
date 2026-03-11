package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;


public class LineDrawerAdapter implements Job2dDriver
{
    private int startX;
    private int startY;
    private ILine line;

    public LineDrawerAdapter(ILine line)
    {
        this.line = line;
    }

    @Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y)
    {
        line.setStartCoordinates(startX, startY);
        line.setEndCoordinates(x, y);

        startX = x;
        startY = y;

        DrawPanelController drawPanelController = DrawerFeature.getDrawerController();
        drawPanelController.drawLine(line);
    }

    @Override
    public String toString()
    {
        return "LineDrawerAdapter";
    }
}
