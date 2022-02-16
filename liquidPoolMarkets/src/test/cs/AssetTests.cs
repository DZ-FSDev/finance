using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Linq;
using System.ComponentModel;

namespace COM.DZ_FSDev.Finance.LiquidPoolMarkets.Tests
{
    [TestClass]
    public class AssetTests
    {
        [DataTestMethod]
        [TestCategory("Asset()")]
        [TestCategory("Initialize")]
        // Arrange
        [DataRow("", "_name")]
        [DataRow("", "_symbol")]
        [DataRow("0", "_assetID")]
        [DataRow("0", "_units")]
        public void Constructor1_Initialize(
            string expectedString, string field)
        {
            // Act
            PrivateObject target = new PrivateObject(
                new Asset());

            // Assert
            var actual = target.GetField(field);
            var expected = actual == null ?
                null : TypeDescriptor.GetConverter(actual).ConvertFrom(expectedString);
            Assert.AreEqual(expected, actual, $"Asset() did not initialize {field} correctly.");
        }

        [TestMethod]
        [TestCategory("Asset(long assetID, string name, string symbol, decimal units)")]
        [TestCategory("Initialize")]
        // Arrange
        [DataRow(20L, "Copper", "Cu", "55.5", "_name", "Copper")]
        [DataRow(20L, "Copper", "Cu", "55.5", "_symbol", "Cu")]
        [DataRow(20L, "Copper", "Cu", "55.5", "_assetID", 20L)]
        [DataRow(20L, "Copper", "Cu", "55.5", "_units", "55.5")]
        public void Constructor2_Initialize(
            long assetID, string name, string symbol, string units, string field, object expectedObject)
        {
            // Act
            PrivateObject target = new PrivateObject(
                new Asset(assetID, name, symbol, Decimal.Parse(units)));

            // Assert
            var actual = target.GetField(field);
            var expected = actual == null ? null :
                actual.GetType() == expectedObject.GetType() ? expectedObject :
                TypeDescriptor.GetConverter(actual).ConvertFrom(expectedObject);
            Assert.AreEqual(expected, actual,
                $"Asset(long assetID, string name, string symbol, decimal units) did not initialize {field} correctly.");
        }

        [TestMethod]
        [TestCategory("Asset(long assetID, string name, string symbol, decimal units)")]
        [TestCategory("Exceptions")]
        // Arrange
        [DataRow(0, "Copper", "Cu", "55.5", "System.ArgumentOutOfRangeException", "when assetID less than 1")]
        [DataRow(20L, "", "Cu", "55.5", "System.ArgumentException", "when name blank")]
        [DataRow(20L, null, "Cu", "55.5", "System.ArgumentNullException", "when name is null")]
        [DataRow(20L, "Copper", "", "55.5", "System.ArgumentException", "when symbol blank")]
        [DataRow(20L, "Copper", null, "55.5", "System.ArgumentNullException", "when symbol is null")]
        public void Constructor2_Exception(
            long assetID, string name, string symbol, string units, string expectedExceptionString, string message)
        {
            // Arrange
            Func<Asset> ctor = () => new Asset(assetID, name, symbol, decimal.Parse(units));

            // Act & Assert
            typeof(Assert).GetMethod("ThrowsException", new Type[] { ctor.GetType(), typeof(string) })
                .MakeGenericMethod(Type.GetType(expectedExceptionString))
                .Invoke(null,new object[] {ctor, message});
        }
    }
}
