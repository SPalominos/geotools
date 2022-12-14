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

/** Extension of {@link org.geotools.styling.FillImpl} dedicated to hatches. */
public class HatchedFill implements Fill, Cloneable {

    private FilterFactory filterFactory;
    private Expression color = null;
    private Expression opacity = null;

    /** The orientation of the hatches */
    private Expression angle = null;
    /** The perpendicular distance between two hatches */
    private Expression distance = null;
    /** The offset of the hatches */
    private Expression offset = null;
    /** The line stroke */
    private Stroke stroke = null;

    /** Creates a new instance of DefaultFill */
    protected HatchedFill() {
        this(CommonFactoryFinder.getFilterFactory(GeoTools.getDefaultHints()));
    }

    public HatchedFill(FilterFactory factory) {
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

    @Override
    public Graphic getGraphicFill() {
        return null;
    }

    @Override
    public void setGraphicFill(org.opengis.style.Graphic graphicFill) {}

    public Expression getAngle() {
        return angle;
    }

    public void setAngle(Expression angle) {
        this.angle = angle;
    }

    public void setAngle(String angle) {
        if (this.angle.toString().equals(angle)) return;

        setAngle(filterFactory.literal(angle));
    }

    public Expression getDistance() {
        return distance;
    }

    public void setDistance(Expression distance) {
        this.distance = distance;
    }

    public void setDistance(String distance) {
        if (this.distance.toString().equals(distance)) return;

        setDistance(filterFactory.literal(distance));
    }

    public Expression getOffset() {
        return offset;
    }

    public void setOffset(Expression offset) {
        this.offset = offset;
    }

    public void setOffset(String offset) {
        if (this.offset.toString().equals(offset)) return;

        setOffset(filterFactory.literal(offset));
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    @Override
    public Object accept(org.opengis.style.StyleVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    @Override
    public void accept(org.geotools.styling.StyleVisitor visitor) {
        visitor.visit(this);
    }

    /** Returns a clone of the FillImpl. */
    @Override
    public HatchedFill clone() {
        HatchedFill clone = new HatchedFill();
        clone.color = color;
        clone.opacity = opacity;
        clone.angle = angle;
        clone.distance = distance;
        clone.offset = offset;
        clone.stroke = stroke;
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
        if (angle != null) {
            result = PRIME * result + angle.hashCode();
        }
        if (distance != null) {
            result = PRIME * result + distance.hashCode();
        }
        if (offset != null) {
            result = PRIME * result + offset.hashCode();
        }
        if (stroke != null) {
            result = PRIME * result + stroke.hashCode();
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

        if (oth instanceof HatchedFill) {
            HatchedFill other = (HatchedFill) oth;
            return Utilities.equals(this.color, other.color)
                    && Utilities.equals(this.opacity, other.opacity);
        }

        return false;
    }

    static HatchedFill cast(org.opengis.style.Fill fill) {
        if (fill == null) {
            return null;
        } else if (fill instanceof HatchedFill) {
            return (HatchedFill) fill;
        }
        return null;
    }
}
