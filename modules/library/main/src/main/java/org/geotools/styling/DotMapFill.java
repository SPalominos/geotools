/*
 * Copyright 2022 Sylvain Palominos / MilliPixel
 *
 * Licensed under the GNU Lesser General Public License 3.0 (LGPL V3). Usage of this file or of "geotools" library have
 * to be compliant with the LGPL V3 license. You can obtain a copy of the LGPL V3 license at :
 * http://www.gnu.org/licenses/lgpl-3.0.html
 *
 * The library geotools is distributed  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package org.geotools.styling;

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.util.Utilities;
import org.geotools.util.factory.GeoTools;
import org.opengis.filter.FilterFactory;
import org.opengis.filter.expression.Expression;
import org.opengis.util.Cloneable;

/** Extension of {@link FillImpl} dedicated to hatches. */
public class DotMapFill implements Fill, Cloneable {

    private FilterFactory filterFactory;
    private Expression color = null;
    private Expression opacity = null;

    /** The orientation of the hatches */
    private Expression quantityPerMark = null;

    private Expression totalQuantity = null;
    private Expression mode = null;
    private Graphic graphicFill = null;

    /** Creates a new instance of DefaultFill */
    protected DotMapFill() {
        this(CommonFactoryFinder.getFilterFactory(GeoTools.getDefaultHints()));
    }

    public DotMapFill(FilterFactory factory) {
        filterFactory = factory;
    }

    public void setFilterFactory(FilterFactory factory) {
        filterFactory = factory;
    }

    @Override
    public Expression getColor() {
        return color;
    }

    @Override
    public void setColor(Expression color) {
        this.color = color;
    }

    public void setColor(String rgb) {
        if (color.toString().equals(rgb)) return;

        setColor(filterFactory.literal(rgb));
    }

    @Override
    public Expression getOpacity() {
        return opacity;
    }

    public void setOpacity(String opacity) {
        if (this.opacity.toString().equals(opacity)) return;

        setOpacity(filterFactory.literal(opacity));
    }

    @Override
    public void setOpacity(Expression opacity) {
        this.opacity = opacity;
    }

    public FilterFactory getFilterFactory() {
        return filterFactory;
    }

    public Expression getQuantityPerMark() {
        return quantityPerMark;
    }

    public void setQuantityPerMark(Expression quantityPerMark) {
        this.quantityPerMark = quantityPerMark;
    }

    public Expression getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Expression totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Expression getMode() {
        return mode;
    }

    public void setMode(Expression mode) {
        this.mode = mode;
    }

    @Override
    public Graphic getGraphicFill() {
        return graphicFill;
    }

    @Override
    public void setGraphicFill(org.opengis.style.Graphic graphicFill) {}

    public void setGraphicFill(Graphic graphicFill) {
        this.graphicFill = graphicFill;
    }

    @Override
    public Object accept(org.opengis.style.StyleVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void accept(StyleVisitor visitor) {
        visitor.visit(this);
    }

    /** Returns a clone of the FillImpl. */
    @Override
    public DotMapFill clone() {
        DotMapFill clone = new DotMapFill();
        clone.color = color;
        clone.opacity = opacity;
        clone.quantityPerMark = quantityPerMark;
        clone.totalQuantity = totalQuantity;
        clone.mode = mode;
        clone.graphicFill = graphicFill;
        return clone;
    }

    /**
     * Generates a hashcode for the FillImpl.
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode() {
        final int PRIME = 1000003;
        int result = 0;
        if (color != null) {
            result = PRIME * result + color.hashCode();
        }
        if (opacity != null) {
            result = PRIME * result + opacity.hashCode();
        }
        if (quantityPerMark != null) {
            result = PRIME * result + quantityPerMark.hashCode();
        }
        if (totalQuantity != null) {
            result = PRIME * result + totalQuantity.hashCode();
        }
        if (mode != null) {
            result = PRIME * result + mode.hashCode();
        }
        if (graphicFill != null) {
            result = PRIME * result + graphicFill.hashCode();
        }

        return result;
    }

    /**
     * Compares a FillImpl with another for equality.
     *
     * <p>Two FillImpls are equal if they contain the same, color, backgroundcolor, opacity and
     * graphicFill.
     *
     * @param oth The other FillImpl
     * @return True if this FillImpl is equal to oth.
     */
    @Override
    public boolean equals(Object oth) {
        if (this == oth) {
            return true;
        }

        if (oth instanceof DotMapFill) {
            DotMapFill other = (DotMapFill) oth;
            return Utilities.equals(this.color, other.color)
                    && Utilities.equals(this.opacity, other.opacity);
        }

        return false;
    }

    static DotMapFill cast(org.opengis.style.Fill fill) {
        if (fill == null) {
            return null;
        } else if (fill instanceof DotMapFill) {
            return (DotMapFill) fill;
        }
        return null;
    }
}
