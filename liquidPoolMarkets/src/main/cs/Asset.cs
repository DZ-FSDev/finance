/*  Original Licensing Copyright
 * 
 *  Represents an Asset in liquid pool markets.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace COM.DZ_FSDev.Finance.LiquidPoolMarkets
{
    /// <summary>
    /// Represents an Asset in liquid pool markets.
    /// </summary>
    public class Asset
    {
        /// <summary>
        /// Gets and sets the Primary Key of this asset.
        /// </summary>
        public long AssetID { get; set; }
        
        /// <summary>
        /// Gets and sets the name of this asset.
        /// </summary>
        public string Name { get; set; }
        
        /// <summary>
        /// Gets and sets the symbol of this asset.
        /// </summary>
        public string Symbol { get; set; }
        
        /// <summary>
        /// Gets and sets the available units of this asset.
        /// </summary>
        public decimal Units { get; set; }

        /// <summary>
        /// Default constructor to initialize an asset.
        /// </summary>
        public Asset() { }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="assetID"></param>
        /// <param name="name"></param>
        /// <param name="symbol"></param>
        /// <param name="units"></param>
        public Asset(long assetID, string name, string symbol, decimal units)
        {
            AssetID = assetID;
            Name = name;
            Symbol = symbol;
            Units = units;
        }
    }
}
