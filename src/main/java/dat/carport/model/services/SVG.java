package dat.carport.model.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private float x;
    private float y;
    private String viewBox;
    private int width;
    private int height;

    private final String ARROWDEFS = "<defs>" +
            "<marker " +
            "id=\"beginArrow\" " +
            "markerWidth=\"12\" " +
            "markerHeight=\"12\" " +
            "refX=\"0\" " +
            "refY=\"6\" " +
            "orient=\"auto\">" +
            "<path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />" +
            "</marker>" +
            "<marker " +
            "id=\"endArrow\" " +
            "markerWidth=\"12\" " +
            "markerHeight=\"12\" " +
            "refX=\"12\" " +
            "refY=\"6\" " +
            "orient=\"auto\">" +
            "<path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />" +
            "</marker>" +
            "</defs>";

    private final String HEADER_TEMPLATE = "<svg height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" x=\"%s\" y=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String RECT_TEMPLATE = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000;fill:#FFF\" />";
    private final String LINE_TEMPLATE = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"black\"";
    private final String ARROW_TEMPLATE = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke: #000;" +
            "marker-start: url(#beginArrow);" +
            "marker-end: url(#endArrow);\" />";
    private final String TEXT_TEMPLATE = "<text style=\"text-anchor: middle\" transform=\"translate(%f,%f) rotate(%f)\">%s</text>";

    public SVG(float x, float y, String viewBox, int width, int height, boolean arrows) {
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

    public void addRect(float x, float y, float width, float height) {
        svg.append(String.format(RECT_TEMPLATE, x, y, height, width));
    }

    public void addLine(float x1, float y1, float x2, float y2, boolean dashedLines) {
        svg.append(String.format(LINE_TEMPLATE, x1, y1, x2, y2));
        svg.append(dashedLines ? " stroke-dasharray=\"8\" />" : " />");
    }

    public void addSVG(SVG innerSVG) {
        svg.append(innerSVG.toString());
    }

    public void addArrow(float x1, float y1, float x2, float y2) {
        svg.append(String.format(ARROW_TEMPLATE, x1, y1, x2, y2));
    }

    public void addText(float translateX, float translateY, float rotate, String text) {
        svg.append(String.format(TEXT_TEMPLATE, translateX, translateY, rotate, text));
    }

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
