package com.bookkeeper;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.VerticalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;


import javax.swing.*;
import java.awt.*;

public class CreateLineChart extends JPanel {
	private String chartTitle;
	private String categoryAxisLabel;
	private String valueAxisLabel;
	
	private boolean createTooltip;
	private boolean showLegend;
	private boolean createURL;
	
	private DefaultCategoryDataset dataset;
	private JFreeChart lineChart;
	private CategoryPlot plot;
	private LineAndShapeRenderer renderer;
	private LegendTitle legend;
	private TextTitle legendText;
	
	private Shape square ;
	
	private  Color lightplainColor = new Color(250, 251, 255);//white
	private  Color darkplainColor = new Color(14, 14, 15);//black
	private  Font plainFont;
	private  int plainTextsize;

	public CreateLineChart(String chartTitle, String categoryAxisLabel, String valueAxisLabel) {
		setBackground(lightplainColor);
		this.chartTitle = chartTitle;
	    this.categoryAxisLabel = categoryAxisLabel;
	    this.valueAxisLabel = valueAxisLabel;
	    
	    //set default 
	    showLegend = false;
		createTooltip = false;
		createURL = false;
		
        dataset = new DefaultCategoryDataset();
        
        lineChart = ChartFactory.createLineChart(
	             chartTitle,categoryAxisLabel , valueAxisLabel, dataset, 
	             PlotOrientation.VERTICAL, showLegend, createTooltip, createURL);
		
        plot = (CategoryPlot) lineChart.getCategoryPlot();
        
        renderer = new LineAndShapeRenderer();
        lineChart.setBackgroundPaint(lightplainColor);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(darkplainColor);        
        plot.setBackgroundPaint(lightplainColor);
        plot.setOutlinePaint(null);
        plot.setRenderer(renderer);
	}
	
	public void addData(String[] xData, int[] yData, String seriesName) {
        for (int i = 0; i < xData.length; i++) {
            dataset.addValue(yData[i], seriesName, xData[i]); 
        }
    }
    public void setSeriesStroke(String seriesName,Stroke stroke) {
    	 int seriesIndex = dataset.getRowIndex(seriesName);
         if (seriesIndex >= 0) {
        	 renderer.setSeriesStroke(seriesIndex,stroke);    
             renderer.setSeriesShapesVisible(seriesIndex, false);
         }
    }
    public void setSeriesPaint(String seriesName, Paint seriesColor) {
        int seriesIndex = dataset.getRowIndex(seriesName);
        if (seriesIndex >= 0) {
            renderer.setSeriesPaint(seriesIndex, seriesColor);
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
	
	public String getCategoryAxisLabel() {
		return categoryAxisLabel;
	}
	public void setCategoryAxisLabel(String categoryAxisLabel) {
		this.categoryAxisLabel = categoryAxisLabel;
	}
	public String getValueAxisLabel() {
		return valueAxisLabel;
	}
	public void setValueAxisLabel(String valueAxisLabel) {
		this.valueAxisLabel = valueAxisLabel;
	}
	public JFreeChart getLineChart() {
	    return lineChart;
	}
	
}
