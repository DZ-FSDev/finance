using Microsoft.VisualStudio.TestTools.UnitTesting;
using COM.DZ_FSDev.Finance.LiquidPoolMarkets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace COM.DZ_FSDev.Finance.LiquidPoolMarkets.Tests
{
    [TestClass]
    public class AssetTests
    {
        [TestMethod]
        [TestCategory("Asset()")]
        public void Constructor1_AssetID_DefaultInitialize()
        {
            // Arrange

            // Act
            PrivateObject target = new PrivateObject(new Asset());

            // Assert
            long expected = 0;
            long actual = (long)target.GetField("assetID");
            Assert.AreEqual(expected, actual);
        }

        [TestMethod]
        [TestCategory("Asset()")]
        public void Constructor1_Name_DefaultInitialize()
        {
            // Arrange

            // Act
            PrivateObject target = new PrivateObject(new Asset());

            // Assert
            string actual = (string)target.GetField("name");
            Assert.IsNull(actual);
        }

        [TestMethod]
        [TestCategory("Asset()")]
        public void Constructor1_Symbol_DefaultInitialize()
        {
            // Arrange

            // Act
            PrivateObject target = new PrivateObject(new Asset());

            // Assert
            string actual = (string)target.GetField("symbol");
            Assert.IsNull(actual);
        }

        [TestMethod]
        [TestCategory("Asset()")]
        public void Constructor1_Units_DefaultInitialize()
        {
            // Arrange

            // Act
            PrivateObject target = new PrivateObject(new Asset());

            // Assert
            decimal expected = 0;
            decimal actual = (decimal)target.GetField("units");
            Assert.AreEqual(expected, actual);
        }

        [TestMethod]
        [TestCategory("Asset(long assetID, string name, string symbol, decimal units)")]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void Constructor2_NegativeAssetID_Exception()
        {
            // Arrange

            // Act
            PrivateObject target = new PrivateObject(new Asset(10, "Copper", "Cu1", 5.5M));

            // Assert
            long expected = 10;
            long actual = (long)target.GetField("assetID");
            Assert.AreEqual(expected, actual);
        }

        [TestMethod]
        [TestCategory("Asset(long assetID, string name, string symbol, decimal units)")]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void CConstructor2_AssetID_Initialize()
        {
            // Arrange

            // Act
            PrivateObject target = new PrivateObject(new Asset(10, "Copper", "Cu1", 5.5M));

            // Assert
            long expected = 10;
            long actual = (long)target.GetField("assetID");
            Assert.AreEqual(expected, actual);
        }
    }
}
