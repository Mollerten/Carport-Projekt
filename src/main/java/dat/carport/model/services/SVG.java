package dat.carport.model.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String ARROWDEFS = "<defs>\n" +
            " <marker \n" +
            " \tid=\"beginArrow\" \n" +
            " \tmarkerWidth=\"12\" \n" +
            " \tmarkerHeight=\"12\" \n" +
            " \trefX=\"0\" \n" +
            " \trefY=\"6\" \n" +
            " \torient=\"auto\">\n" +
            "   <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            " </marker>\n" +
            " <marker \n" +
            " \tid=\"endArrow\" \n" +
            " \tmarkerWidth=\"12\" \n" +
            " \tmarkerHeight=\"12\" \n" +
            " \trefX=\"12\" \n" +
            " \trefY=\"6\" \n" +
            " \torient=\"auto\">\n" +
            "   <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            " </marker>\n" +
            "</defs>";

    private final String HEADER_TEMPLATE = "<svg height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" x=\"%s\" y=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String RECT_TEMPLATE = "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000;fill:#FFF\" />";
    private final String LINE_TEMPLATE = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"black\"";
    private final String ARROW_TEMPLATE = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke: #000;" +
            "marker-start: url(#beginArrow);" +
            "marker-end: url(#endArrow);\" />";

    public SVG(int x, int y, String viewBox, int width, int height, boolean arrows) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(HEADER_TEMPLATE, height, width, viewBox, x, y));
        if (arrows) {
            svg.append(ARROWDEFS);
        }
    }

    public void addRect(int x, int y, float width, float height) {
        svg.append(String.format(RECT_TEMPLATE, x, y, height, width));
    }

    public void addLine(int x1, int y1, int x2, int y2, boolean dashedLines) {
        svg.append(String.format(LINE_TEMPLATE, x1, y1, x2, y2));
        if (dashedLines) {
            svg.append(" stroke-dasharray=\"8\" />");
        } else {
            svg.append(" />");
        }
    }

    public void addSVG(SVG innerSVG) {
        svg.append(innerSVG.toString());
    }

    public void addArrow(int x1, int y1, int x2, int y2) {
        svg.append(String.format(ARROW_TEMPLATE, x1, y1, x2, y2));
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
