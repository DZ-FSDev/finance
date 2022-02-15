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
        private long _assetID; 
        private string _symbol;
        private string _name;
        private decimal _units;

        /// <summary>
        /// Gets and sets the Primary Key of this asset.
        /// </summary>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when AssetID is set to less than 1.
        /// </exception>
        public long AssetID
        {
            get { return _assetID; }
            set
            {
                if(value < 1)
                    throw new ArgumentOutOfRangeException("AssetID cannot be less than 1.");
                _assetID = value;
            }
        }
        
        /// <summary>
        /// Gets and sets the name of this asset.
        /// </summary>
        public string Name
        {
            get { return _name; }
            set
            {
                value = value?.Trim() ?? throw new ArgumentNullException("value", "Name cannot be null.");
                if (value.Length == 0) throw new ArgumentException("Name cannot be empty.", "value");
                _name = value;
            }
        }
        
        /// <summary>
        /// Gets and sets the symbol of this asset.
        /// </summary>
        /// <exception cref="ArgumentNullException">
        /// 
        /// </exception>
        /// <exception cref="ArgumentException">
        /// 
        /// </exception>
        public string Symbol
        {
            get { return _symbol; }
            
            set
            {
                value = value?.Trim() ?? throw new ArgumentNullException("value", "Symbol cannot be null.");
                if (value.Length == 0) throw new ArgumentException("Symbol cannot be empty.","value");

                _symbol = value;
            }
        }
        
        /// <summary>
        /// Gets and sets the available units of this asset.
        /// </summary>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when units is set to less than 0.
        /// </exception>
        public decimal Units
        {
            get { return _units; }
            set
            {
                if (value < 0)
                    throw new ArgumentOutOfRangeException("Units cannot be less than or equal to 0.");
                _units = value;
            }
        }

        /// <summary>
        /// Default constructor to initialize an asset.
        /// </summary>
        public Asset() { }

        /// <summary>
        /// Initializes a new Asset instance which is referenced in a
        /// liquid pool market.
        /// </summary>
        /// <param name="assetID">
        /// The primary key of the new Asset.
        /// </param>
        /// <param name="name">
        /// The name of the new Asset.
        /// </param>
        /// <param name="symbol">
        /// The symbol of the new Asset.
        /// </param>
        /// <param name="units">
        /// The units of the new Asset.
        /// </param>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when <paramref name="assetID"/> is less than 1;
        /// or when <paramref name="units"/> is less than or equal to 0.
        /// </exception>
        public Asset(long assetID, string name, string symbol, decimal units)
        {
            AssetID = assetID;
            Name = name;
            Symbol = symbol;
            Units = units;
        }
    }
}
