package dat.carport.model.services;

public class SVG {

    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String HEADER_TEMPLATE = "<svg height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" x=\"%s\" y=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final String RECT_TEMPLATE = "<rect x=\"%d\" y=\"%d\" height=\"%d\" width=\"%d\" style=\"stroke:#000;fill:#FFF\" />";
    private final String LINE_TEMPLATE = "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"black\"";

    public SVG(int x, int y, String viewBox, int width, int height) {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(HEADER_TEMPLATE, height, width, viewBox, x, y));
    }

    public void addRect(int x, int y, int height, int width) {
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

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
