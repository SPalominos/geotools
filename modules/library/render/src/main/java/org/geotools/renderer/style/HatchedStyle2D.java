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

/** @author Sylvain Palominos (MilliPixel) */
public class HatchedStyle2D extends LineStyle2D {
    protected double angle;
    protected double distance;
    protected Color color;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
