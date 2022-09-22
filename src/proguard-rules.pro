# Add any ProGuard configurations specific to this
# extension here.

-keep public class in.akshatt.SecureDB.SecureDB {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'in/akshatt/SecureDB/repack'
-flattenpackagehierarchy
-dontpreverify
