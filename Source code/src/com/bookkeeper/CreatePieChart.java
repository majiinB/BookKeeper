package com.bookkeeper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Stroke;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.VerticalAlignment;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;

public class CreatePieChart extends JPanel {
	private String chartTitle;
	
	private boolean createTooltip;
	private boolean showLegend;
	private boolean createURL;
	
	private JFreeChart pieChart;
	private DefaultPieDataset dataset;
	private PiePlot plot;
	private LegendTitle legend;
	private TextTitle legendText;
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  int plainTextsize=   Math.min(getHeight() / 60, getWidth()/ 60);
	private  Font plainFont = new Font("Montserrat", Font.PLAIN, plainTextsize);
	private  Color lightplainColor = new Color(250, 251, 255);//white

	
	public  CreatePieChart(String chartTitle) {
		setBackground(lightplainColor);
		setOpaque(false);
		
	    this.chartTitle = chartTitle;
	    //set default 
	    showLegend = false;
		createTooltip = false;
		createURL = false;
		dataset = new DefaultPieDataset();
	        
	    pieChart = ChartFactory.createPieChart(
	    		chartTitle,  dataset, showLegend, createTooltip, createURL
	    		);
	    
	    plot = (PiePlot) pieChart.getPlot();	 
	    
//	    plot.setLegendItemShape(new Rectangle(25,25));
	    plot.setShadowPaint(null);
	    plot.setBackgroundPaint(new Color(0, 0, 0, 0));         plot.setLabelGenerator(null);
        plot.setOutlinePaint(null);
        pieChart.getPlot().setBackgroundPaint(lightplainColor);
	}
	public void addData(String[] seriesName, int[] value) {
        for (int i = 0; i < seriesName.length; i++) {
        	dataset.setValue(seriesName[i],value[i]);
	    }
	}
    public void setSectionPaint(String[] seriesName,Color[] Color) {
        for (int i = 0; i < seriesName.length; i++) {
        	plot.setSectionPaint(seriesName[i],Color[i]);    
        }
   }
	public Boolean getShowLegend() {
		return showLegend;
	}
	public void setShowLegend(Boolean showLegend) {
	    this.showLegend = showLegend;
	}
	public String getChartTitle() {
		return chartTitle;
	}
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}
	public JFreeChart getPieChart() {
	    return pieChart;
	}
}
