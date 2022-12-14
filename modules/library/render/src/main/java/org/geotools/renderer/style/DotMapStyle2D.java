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
package org.geotools.renderer.style;

import java.awt.*;
import org.geotools.styling.Graphic;

/** @author Sylvain Palominos (MilliPixel) */
public class DotMapStyle2D extends Style2D {
    protected double quantityPerMark;
    protected double totalQuantity;
    protected String mode;
    protected Graphic graphic = null;

    public double getQuantityPerMark() {
        return quantityPerMark;
    }

    public void setQuantityPerMark(double quantityPerMark) {
        this.quantityPerMark = quantityPerMark;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Graphic getGraphic() {
        return graphic;
    }

    public void setGraphic(Graphic graphic) {
        this.graphic = graphic;
    }
}
