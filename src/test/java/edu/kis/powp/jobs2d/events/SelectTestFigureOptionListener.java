package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private int figure = 0;
	private final List<Runnable> figures = List.of(
		() -> FiguresJoe.figureScript1(driverManager.getCurrentDriver()),
		() -> FiguresJoe.figureScript2(driverManager.getCurrentDriver()),
		() -> FiguresJane.figureScript(new AbstractDriverAdapter())
	);

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public SelectTestFigureOptionListener(DriverManager driverManager, int figure) {
		this(driverManager);
		this.figure = figure;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		figures.get(figure).run();
	}
}
