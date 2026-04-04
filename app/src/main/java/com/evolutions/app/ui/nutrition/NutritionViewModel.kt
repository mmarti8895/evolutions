package com.evolutions.app.ui.nutrition

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evolutions.app.data.models.NutritionItem

class NutritionViewModel : ViewModel() {

    private val _allItems = MutableLiveData<List<NutritionItem>>()

    private val _nutritionItems = MutableLiveData<List<NutritionItem>>()
    val nutritionItems: LiveData<List<NutritionItem>> = _nutritionItems

    private val _selectedCategory = MutableLiveData<String>("All")
    val selectedCategory: LiveData<String> = _selectedCategory

    val categories = listOf("All", "Protein", "Recovery", "Anti-Inflammatory", "Carb", "Fat", "Avoid")

    init {
        loadNutritionItems()
    }

    fun filterByCategory(category: String) {
        _selectedCategory.value = category
        _nutritionItems.value = if (category == "All") {
            _allItems.value
        } else {
            _allItems.value?.filter { it.category == category }
        }
    }

    private fun loadNutritionItems() {
        val items = buildNutritionItems()
        _allItems.value = items
        _nutritionItems.value = items
    }

    private fun buildNutritionItems(): List<NutritionItem> = listOf(

        // ── PROTEINS ──────────────────────────────────────────────────────────

        NutritionItem(
            id = 1,
            name = "Eggs (Scrambled or Poached)",
            category = "Protein",
            description = "One of the most bioavailable protein sources available. Gentle on digestion and easy to prepare.",
            benefits = "Complete protein (all essential amino acids), choline for brain health, vitamin D for bone density — important for estrogen therapy support.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "2–3 eggs scrambled in a small amount of olive oil. Avoid high-fat additions during flares.",
            caloriesPerServing = 180
        ),
        NutritionItem(
            id = 2,
            name = "Chicken Breast (Well-Cooked)",
            category = "Protein",
            description = "Lean, versatile, and easy to digest when cooked thoroughly without skin.",
            benefits = "High lean protein (31g per 3.5oz) supports muscle repair after workouts. Low fat means easy on gut during Crohn's flares.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "3–4 oz baked or boiled. Season with herbs — avoid spicy rubs. Pair with white rice for complete recovery meal.",
            caloriesPerServing = 165
        ),
        NutritionItem(
            id = 3,
            name = "Salmon (Baked or Steamed)",
            category = "Protein",
            description = "Fatty fish rich in omega-3s — one of the most powerful natural anti-inflammatory foods available.",
            benefits = "Omega-3 fatty acids (EPA/DHA) reduce joint inflammation for arthritis and injury recovery. Also supports estrogen metabolism. 25g protein per serving.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = true,
            servingSuggestion = "3–4 oz twice per week. Bake at 400°F with lemon and dill. Avoid heavy cream sauces.",
            caloriesPerServing = 200
        ),
        NutritionItem(
            id = 4,
            name = "Canned Tuna in Water",
            category = "Protein",
            description = "Convenient, affordable lean protein that requires no cooking. Easy to keep on hand.",
            benefits = "25g protein per can. Low fat, quick to absorb. Good post-workout protein when a full meal isn't possible.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "Mix 1 can with a small amount of mayo or olive oil. Eat with white crackers or white rice. Limit to 2–3 times per week due to mercury.",
            caloriesPerServing = 130
        ),
        NutritionItem(
            id = 5,
            name = "Firm Tofu (Well-Cooked)",
            category = "Protein",
            description = "Plant-based complete protein that also contains phytoestrogens — compounds that may gently support hormonal balance.",
            benefits = "Complete plant protein. Phytoestrogens may complement estrogen therapy. Rich in calcium for bone density.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "Pan-fry or bake until firm. Soft or raw tofu may be harder to digest during flares.",
            caloriesPerServing = 180
        ),
        NutritionItem(
            id = 6,
            name = "Greek Yogurt (Plain, Low-Fat)",
            category = "Protein",
            description = "High-protein dairy option with probiotics that may support gut health. Use if dairy is tolerated.",
            benefits = "17g protein per 6oz serving. Probiotics (Lactobacillus) may help balance gut microbiome. Calcium supports bones.",
            crohnsFriendly = false,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "Tolerate test only — some people with Crohn's do fine with low-fat dairy, others don't. Start with a small portion.",
            caloriesPerServing = 100
        ),

        // ── RECOVERY FOODS ───────────────────────────────────────────────────

        NutritionItem(
            id = 7,
            name = "Bone Broth",
            category = "Recovery",
            description = "Collagen-rich broth made from simmering animal bones. Soothing, gut-healing, and joint-supportive.",
            benefits = "Collagen and gelatin support gut lining integrity — crucial for Crohn's management. Glycine reduces inflammation. Supports joint cartilage.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = true,
            servingSuggestion = "1–2 cups daily, especially on workout days or during mild flares. Sip warm. Excellent on an empty stomach in the morning.",
            caloriesPerServing = 40
        ),
        NutritionItem(
            id = 8,
            name = "Banana",
            category = "Recovery",
            description = "The ideal pre- or post-workout snack. Easy to digest, potassium-rich, and naturally sweet.",
            benefits = "Potassium prevents muscle cramps. Quick-release carbohydrates fuel energy. Gentle on the gut even during sensitive periods.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "1 medium banana 30 minutes before a workout, or immediately after. Pair with a small amount of peanut butter if tolerated.",
            caloriesPerServing = 105
        ),
        NutritionItem(
            id = 9,
            name = "White Rice",
            category = "Recovery",
            description = "The classic Crohn's-friendly carbohydrate. Low-fiber, easy to digest, and excellent for replenishing glycogen.",
            benefits = "Replenishes muscle glycogen after exercise. Gentle on inflamed gut. BRAT diet staple for Crohn's flare management.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "½–1 cup cooked white rice with lean protein. Avoid adding high-fat or spicy sauces during flares.",
            caloriesPerServing = 200
        ),
        NutritionItem(
            id = 10,
            name = "Oatmeal (Well-Cooked, Plain)",
            category = "Recovery",
            description = "Soluble fiber (beta-glucan) that is generally well-tolerated in Crohn's when cooked thoroughly and eaten in remission.",
            benefits = "Sustained energy release. Soluble fiber is gentler than insoluble. Beta-glucan supports healthy cholesterol.",
            crohnsFriendly = true,
            lowFiber = false,
            antiInflammatory = false,
            servingSuggestion = "During remission only. Cook well with water or lactose-free milk. Top with banana slices. Avoid during active flares.",
            caloriesPerServing = 150
        ),

        // ── ANTI-INFLAMMATORY ─────────────────────────────────────────────────

        NutritionItem(
            id = 11,
            name = "Turmeric (with Black Pepper)",
            category = "Anti-Inflammatory",
            description = "Curcumin in turmeric is one of the most studied natural anti-inflammatories. Black pepper (piperine) increases absorption by 2000%.",
            benefits = "Reduces joint inflammation from arthritis. May help manage Crohn's inflammation. Supports overall inflammatory response.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = true,
            servingSuggestion = "Add ¼ tsp turmeric + pinch of black pepper to rice, soups, or warm water. Golden milk (turmeric + non-dairy milk) is a soothing evening drink.",
            caloriesPerServing = 8
        ),
        NutritionItem(
            id = 12,
            name = "Fresh Ginger",
            category = "Anti-Inflammatory",
            description = "Potent anti-inflammatory and digestive aid. Ginger has been used for centuries for gut issues and joint pain.",
            benefits = "Gingerols reduce inflammatory markers. Supports digestion and can ease nausea — helpful during Crohn's episodes.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = true,
            servingSuggestion = "Grate fresh ginger into hot water with lemon for a healing tea. Add to soups or stir-fries in small amounts.",
            caloriesPerServing = 5
        ),
        NutritionItem(
            id = 13,
            name = "Blueberries",
            category = "Anti-Inflammatory",
            description = "Antioxidant-rich berries that fight inflammation and oxidative stress without being harsh on the gut.",
            benefits = "Anthocyanins reduce muscle damage after exercise. Supports brain health and memory. Low glycemic index.",
            crohnsFriendly = true,
            lowFiber = false,
            antiInflammatory = true,
            servingSuggestion = "½ cup fresh or frozen blueberries. Blend into a smoothie with banana and protein powder, or eat as a snack during remission.",
            caloriesPerServing = 85
        ),
        NutritionItem(
            id = 14,
            name = "Olive Oil (Extra Virgin)",
            category = "Fat",
            description = "Heart-healthy monounsaturated fat with powerful anti-inflammatory compounds, including oleocanthal.",
            benefits = "Oleocanthal acts similarly to ibuprofen in reducing inflammation. Supports vitamin absorption. Heart and brain healthy.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = true,
            servingSuggestion = "1–2 tablespoons daily. Drizzle on cooked vegetables, mix into rice, or use for light sautéing. Avoid high-heat frying.",
            caloriesPerServing = 120
        ),
        NutritionItem(
            id = 15,
            name = "Omega-3 Fish Oil Supplement",
            category = "Anti-Inflammatory",
            description = "If dietary fish intake is insufficient, fish oil capsules provide concentrated EPA/DHA for consistent anti-inflammatory support.",
            benefits = "Clinically proven to reduce joint stiffness and inflammation. Supports mood regulation and estrogen metabolism.",
            crohnsFriendly = true,
            lowFiber = true,
            antiInflammatory = true,
            servingSuggestion = "1000–2000mg EPA+DHA daily with food to avoid fishy burps. Consult your doctor as fish oil can interact with some medications.",
            caloriesPerServing = 10
        ),

        // ── FOODS TO APPROACH CAREFULLY / AVOID ───────────────────────────────

        NutritionItem(
            id = 16,
            name = "Raw Vegetables (High Fiber)",
            category = "Avoid",
            description = "Raw fibrous vegetables like broccoli, cabbage, and kale are very high in insoluble fiber and can trigger Crohn's symptoms.",
            benefits = "High in vitamins — but these benefits must be weighed against digestive risk.",
            crohnsFriendly = false,
            lowFiber = false,
            antiInflammatory = false,
            servingSuggestion = "Cook vegetables thoroughly to break down fiber. Peel and seed when possible. Avoid entirely during flares.",
            caloriesPerServing = 0
        ),
        NutritionItem(
            id = 17,
            name = "Spicy Foods",
            category = "Avoid",
            description = "Capsaicin in spicy foods can irritate the intestinal lining and trigger Crohn's flares and discomfort.",
            benefits = "None recommended for your situation.",
            crohnsFriendly = false,
            lowFiber = true,
            antiInflammatory = false,
            servingSuggestion = "Use mild herbs (basil, dill, parsley) instead of hot peppers or cayenne.",
            caloriesPerServing = 0
        ),
        NutritionItem(
            id = 18,
            name = "Beans and Legumes (During Flares)",
            category = "Avoid",
            description = "High in insoluble fiber and FODMAPs, which can cause gas, bloating, and worsen Crohn's symptoms during active periods.",
            benefits = "Excellent protein source during remission, but risky during flares.",
            crohnsFriendly = false,
            lowFiber = false,
            antiInflammatory = false,
            servingSuggestion = "Only consider lentils (well-cooked, small portions) during stable remission. Always avoid during flares.",
            caloriesPerServing = 0
        )
    )
}
