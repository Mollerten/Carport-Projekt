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

    @Override
    public String toString() {
        return svg.toString() + "</svg>";
    }
}
