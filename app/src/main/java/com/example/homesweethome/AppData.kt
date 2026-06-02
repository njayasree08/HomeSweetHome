package com.example.homesweethome

object AppData {
    var userName: String = "User"
    val cartItems = mutableListOf<Pair<HomeProduct, Int>>()

    const val FIXED_EMAIL = "njayasree033@gmail.com"
    const val FIXED_PASSWORD = "080806"
    const val DELIVERY_CHARGE = 37.90
    
    const val UPI_PIN_4 = "2026"
    const val UPI_PIN_6 = "220626"

    fun addToCart(product: HomeProduct, quantity: Int) {
        val index = cartItems.indexOfFirst { it.first.id == product.id }
        if (index != -1) {
            val oldQty = cartItems[index].second
            cartItems[index] = product to (oldQty + quantity)
        } else {
            cartItems.add(product to quantity)
        }
    }

    val homeProducts = listOf(
        // Dashboard Specials: 3 at $47.80, 2 at $0.00
        HomeProduct(1, "Premium Laundry Set", "Complete home laundry solution", 47.80, "Bundle includes detergent, softener, and scent boosters.", android.R.drawable.ic_menu_manage, 4.9),
        HomeProduct(2, "Kitchen Master Kit", "Essential kitchen cleaning tools", 47.80, "Includes dish soap, sponges, and surface cleaner.", android.R.drawable.ic_menu_manage, 4.8),
        HomeProduct(3, "Home Safety Bundle", "Protection for your family", 47.80, "Flashlight, batteries, and first aid essentials.", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(4, "Eco-Friendly Sponge", "FREE WITH DEAL", 0.0, "Complimentary eco-friendly sponge for new users.", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(5, "Sample Air Freshener", "FREE WITH DEAL", 0.0, "Free trial of our lavender mist spray.", android.R.drawable.ic_menu_manage, 4.6),

        // 50+ Regular Products
        HomeProduct(101, "Liquid Detergent", "CleanHome - 5L Economy Pack", 12.50, "High efficiency laundry detergent for all washers", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(102, "Dish Soap", "Sparkle - 750ml Lemon", 3.20, "Grease-cutting dish liquid with lemon scent", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(103, "Floor Cleaner", "FreshFloor - 2L Pine", 7.80, "Multi-surface floor solution for tile and wood", android.R.drawable.ic_menu_manage, 4.3),
        HomeProduct(104, "Paper Towels", "SoftAbsorb - 6 Roll Pack", 14.99, "2-ply highly absorbent towels (6 pack)", android.R.drawable.ic_menu_manage, 4.8),
        HomeProduct(105, "Trash Bags", "StrongHold - 50ct 13Gal", 9.45, "Leak-proof 13-gallon bags (50 count)", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(106, "Glass Cleaner", "ClearView - 500ml Spray", 4.30, "Streak-free shine formula for windows and mirrors", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(107, "Toilet Cleaner", "SafeGerm - 750ml Gel", 5.20, "Kills 99.9% of germs with powerful cleaning action", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(108, "Fabric Softener", "SilkyTouch - 1.5L Lavender", 6.75, "Long-lasting freshness and softness for fabrics", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(109, "Microfiber Cloths", "QuickWipe - 4 Pack", 5.50, "Lint-free cloths for multi-purpose cleaning", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(110, "Hand Soap Refill", "MoisturizePlus - 1L", 4.90, "Antibacterial liquid hand soap with aloe vera", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(111, "All-Purpose Spray", "VersaClean - 1L", 6.20, "Effective against grease, grime, and soap scum", android.R.drawable.ic_menu_manage, 4.3),
        HomeProduct(112, "Dishwasher Pods", "AutoShine - 30ct", 11.40, "Platinum power pods for spotless dishes", android.R.drawable.ic_menu_manage, 4.8),
        HomeProduct(113, "Drain Unblocker", "FastFlow - 1L Gel", 8.90, "Dissolves hair and grease clogs instantly", android.R.drawable.ic_menu_manage, 4.2),
        HomeProduct(114, "Sponge Mop", "SweepUp - Telescopic", 18.50, "Heavy-duty absorbent mop for all floor types", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(115, "Broom Set", "DustFree - With Pan", 13.20, "Angled bristles for easy corner cleaning", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(116, "Furniture Polish", "WoodGlow - 400ml", 7.40, "Beeswax formula for deep wood nourishment", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(117, "Steel Wool Pads", "ScrubKing - 10 Pack", 3.80, "Tough on burnt-on food and rust", android.R.drawable.ic_menu_manage, 4.3),
        HomeProduct(118, "Air Freshener Plug-in", "AromaHome - Kit", 10.50, "Continuous fragrance for up to 60 days", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(119, "Descaler", "LimescaleOff - 500ml", 6.40, "Removes stubborn limescale from kettles and taps", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(120, "Storage Bins", "ClearOrganize - 3 Pack", 22.00, "Stackable bins for pantry and closet organization", android.R.drawable.ic_menu_manage, 4.8),
        HomeProduct(121, "Laundry Basket", "EasyCarry - 40L", 15.90, "Ergonomic handles for comfortable transport", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(122, "LED Bulbs", "BrightEco - 4 Pack 9W", 12.80, "Energy-saving warm white LED bulbs", android.R.drawable.ic_menu_manage, 4.9),
        HomeProduct(123, "Batteries AA", "PowerLast - 12 Pack", 9.20, "High-performance alkaline batteries", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(124, "Extension Lead", "LinkSafe - 3m 4-Way", 11.50, "Surge protected power strip with safety shutters", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(125, "First Aid Kit", "RescueReady - 50 Piece", 19.99, "Comprehensive kit for minor home emergencies", android.R.drawable.ic_menu_manage, 4.8),
        HomeProduct(126, "Smoke Detector", "GuardHome - Battery Op", 14.50, "Photoelectric sensor for early fire detection", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(127, "Door Mat", "WelcomeHome - Coir", 11.00, "Durable natural fiber mat for scraping dirt", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(128, "Kitchen Scale", "ExactWeight - Digital", 16.50, "Precision sensors for accurate measurements", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(129, "Oven Gloves", "HeatSafe - Silicone", 9.80, "Heat resistant up to 500°F with non-slip grip", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(130, "Water Filter Pitcher", "PureDrop - 2.4L", 24.90, "Reduces chlorine and heavy metals for better taste", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(131, "Cutlery Set", "DineIn - 24 Piece", 35.00, "Stainless steel set with mirror finish", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(132, "Non-Stick Pan", "CookEasy - 28cm", 29.00, "PFOA-free coating for healthy cooking", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(133, "Storage Jars", "SealFresh - Set of 5", 18.20, "Airtight lids for keeping dry foods fresh", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(134, "Dish Rack", "DryRight - 2 Tier", 21.50, "Rust-proof aluminum with drainage board", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(135, "Salt & Pepper Grinders", "SpiceIt - Pair", 14.00, "Adjustable ceramic grinding mechanism", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(136, "Tea Towels", "CottonSoft - 3 Pack", 8.50, "Highly absorbent 100% cotton towels", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(137, "Bathroom Scale", "TrackFit - Digital", 23.00, "Step-on technology with large LCD display", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(138, "Shower Curtain", "WaterShield - PEVA", 12.00, "Mildew resistant and 100% waterproof", android.R.drawable.ic_menu_manage, 4.3),
        HomeProduct(139, "Bath Mat", "SoftStep - Memory Foam", 14.80, "Luxurious absorbent mat with non-slip base", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(140, "Soap Dispenser", "StyleWash - Glass", 9.50, "Elegant design with durable pump mechanism", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(141, "Toilet Brush", "CleanCorner - Silicone", 11.20, "Flexible bristles for deep rim cleaning", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(142, "Towel Ring", "HoldTight - Chrome", 8.90, "Wall-mounted rust-resistant towel holder", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(143, "Laundry Pods", "CleanHome - 30ct", 10.50, "All-in-one laundry detergent pods", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(144, "Drain Snake", "ToolMaster - 5ft", 6.80, "Flexible tool for clearing sink clogs", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(145, "Utility Knife", "CutRight - Retractable", 4.20, "Heavy-duty box cutter for home use", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(146, "Super Glue", "StickOn - 3 Pack", 3.50, "Fast-acting strong adhesive bond", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(147, "Duct Tape", "FixIt - 50m Silver", 5.90, "Strong waterproof tape for all repairs", android.R.drawable.ic_menu_manage, 4.8),
        HomeProduct(148, "Drawer Liners", "FreshScent - 6 Sheets", 7.20, "Fragrant non-slip liners for drawers", android.R.drawable.ic_menu_manage, 4.5),
        HomeProduct(149, "Hanging Hooks", "HoldTight - 10 Pack", 4.80, "Adhesive-backed hooks for walls", android.R.drawable.ic_menu_manage, 4.4),
        HomeProduct(150, "Curtain Rod", "WindowStyle - Extendable", 15.00, "Sturdy metal rod with finials", android.R.drawable.ic_menu_manage, 4.6),
        HomeProduct(151, "Flashlight LED", "BrightWay - Tactical", 12.50, "High-intensity waterproof flashlight", android.R.drawable.ic_menu_manage, 4.7),
        HomeProduct(152, "Step Ladder", "SafeReach - 2 Step", 25.00, "Folding stool with non-slip steps", android.R.drawable.ic_menu_manage, 4.8)
    )
}
