package com.evolutions.app.ui.learn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evolutions.app.data.ThaiContentData
import com.evolutions.app.data.ThaiVideosData
import com.evolutions.app.data.models.KnowledgeTopic
import com.evolutions.app.data.models.ScriptItem
import com.evolutions.app.data.models.ThaiBook
import com.evolutions.app.data.models.ThaiLesson
import com.evolutions.app.data.models.ThaiVideo
import com.evolutions.app.data.models.ThaiWord

class LearnViewModel : ViewModel() {

    private val _selectedTab = MutableLiveData<String>("Thai")
    val selectedTab: LiveData<String> = _selectedTab

    private val _thaiWords = MutableLiveData<List<ThaiWord>>()
    val thaiWords: LiveData<List<ThaiWord>> = _thaiWords

    private val _filteredThaiWords = MutableLiveData<List<ThaiWord>>()
    val filteredThaiWords: LiveData<List<ThaiWord>> = _filteredThaiWords

    private val _knowledgeTopics = MutableLiveData<List<KnowledgeTopic>>()
    val knowledgeTopics: LiveData<List<KnowledgeTopic>> = _knowledgeTopics

    private val _filteredKnowledge = MutableLiveData<List<KnowledgeTopic>>()
    val filteredKnowledge: LiveData<List<KnowledgeTopic>> = _filteredKnowledge

    private val _selectedThaiCategory = MutableLiveData<String>("All")
    val selectedThaiCategory: LiveData<String> = _selectedThaiCategory

    private val _selectedKnowledgeCategory = MutableLiveData<String>("All")
    val selectedKnowledgeCategory: LiveData<String> = _selectedKnowledgeCategory

    // New Thai section data
    private val _lessons = MutableLiveData<List<ThaiLesson>>()
    private val _filteredLessons = MutableLiveData<List<ThaiLesson>>()
    val filteredLessons: LiveData<List<ThaiLesson>> = _filteredLessons

    private val _scripts = MutableLiveData<List<ScriptItem>>()
    private val _filteredScripts = MutableLiveData<List<ScriptItem>>()
    val filteredScripts: LiveData<List<ScriptItem>> = _filteredScripts

    private val _books = MutableLiveData<List<ThaiBook>>()
    private val _filteredBooks = MutableLiveData<List<ThaiBook>>()
    val filteredBooks: LiveData<List<ThaiBook>> = _filteredBooks

    private val _videos = MutableLiveData<List<ThaiVideo>>()
    private val _filteredVideos = MutableLiveData<List<ThaiVideo>>()
    val filteredVideos: LiveData<List<ThaiVideo>> = _filteredVideos

    val thaiCategories = listOf("All", "Greetings", "Muay Thai", "Numbers", "Food", "Essentials", "Polite")
    val knowledgeCategories = listOf("All", "Cybersecurity", "Exercise Science", "Nutrition", "Biology", "Mindfulness")

    val thaiSections = listOf("🗣️ Words", "📚 Lessons", "🔤 Scripts", "📖 Library", "🎬 Videos")

    val lessonCategories = listOf("All", "Tones", "Pronunciation", "Phrases", "Numbers", "Grammar")
    val scriptCategories = listOf("All", "Consonants", "Vowels", "Tone Rules", "Passages")
    val bookCategories = listOf("All", "Thai Classic", "English Classic", "Bilingual")
    val videoCategories = ThaiVideosData.videoCategories

    init {
        loadThaiWords()
        loadKnowledgeTopics()
        loadLessons()
        loadScripts()
        loadBooks()
        loadVideos()
    }

    fun selectTab(tab: String) {
        _selectedTab.value = tab
    }

    fun filterThaiByCategory(category: String) {
        _selectedThaiCategory.value = category
        _filteredThaiWords.value = if (category == "All") {
            _thaiWords.value
        } else {
            _thaiWords.value?.filter { it.category == category }
        }
    }

    fun filterKnowledgeByCategory(category: String) {
        _selectedKnowledgeCategory.value = category
        _filteredKnowledge.value = if (category == "All") {
            _knowledgeTopics.value
        } else {
            _knowledgeTopics.value?.filter { it.category == category }
        }
    }

    fun filterLessonsByCategory(category: String) {
        _filteredLessons.value = if (category == "All") {
            _lessons.value
        } else {
            _lessons.value?.filter { it.category == category }
        }
    }

    fun filterScriptsByCategory(category: String) {
        _filteredScripts.value = if (category == "All") {
            _scripts.value
        } else {
            val typeMap = mapOf(
                "Consonants" to "consonant",
                "Vowels" to "vowel",
                "Tone Rules" to "tone_rule",
                "Passages" to "passage"
            )
            val type = typeMap[category] ?: category.lowercase()
            _scripts.value?.filter { it.type == type }
        }
    }

    fun filterBooksByCategory(category: String) {
        _filteredBooks.value = if (category == "All") {
            _books.value
        } else {
            _books.value?.filter { it.language == category }
        }
    }

    fun filterVideosByCategory(category: String) {
        _filteredVideos.value = if (category == "All") {
            _videos.value
        } else {
            _videos.value?.filter { it.category == category }
        }
    }

    private fun loadThaiWords() {
        val words = buildThaiWords()
        _thaiWords.value = words
        _filteredThaiWords.value = words
    }

    private fun loadKnowledgeTopics() {
        val topics = buildKnowledgeTopics()
        _knowledgeTopics.value = topics
        _filteredKnowledge.value = topics
    }

    private fun loadLessons() {
        val lessons = ThaiContentData.getLessons()
        _lessons.value = lessons
        _filteredLessons.value = lessons
    }

    private fun loadScripts() {
        val scripts = ThaiContentData.getConsonants() +
            ThaiContentData.getVowels() +
            ThaiContentData.getToneRules() +
            ThaiContentData.getPassages()
        _scripts.value = scripts
        _filteredScripts.value = scripts
    }

    private fun loadBooks() {
        val books = ThaiContentData.getBooks()
        _books.value = books
        _filteredBooks.value = books
    }

    private fun loadVideos() {
        val videos = ThaiVideosData.getVideos()
        _videos.value = videos
        _filteredVideos.value = videos
    }

    private fun buildThaiWords(): List<ThaiWord> = listOf(

        // ── GREETINGS ─────────────────────────────────────────────────────────

        ThaiWord(
            id = 1,
            english = "Hello",
            thai = "สวัสดี",
            phonetic = "sà-wàt-dee",
            category = "Greetings",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%A7%E0%B8%B1%E0%B8%AA%E0%B8%94%E0%B8%B5&tl=th&client=tw-ob",
            usageExample = "สวัสดีค่ะ (sà-wàt-dee kâ) — Hello (polite, female speaker)"
        ),
        ThaiWord(
            id = 2,
            english = "How are you?",
            thai = "สบายดีไหม",
            phonetic = "sà-baai dee mǎi",
            category = "Greetings",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%9A%E0%B8%B2%E0%B8%A2%E0%B8%94%E0%B8%B5%E0%B9%84%E0%B8%AB%E0%B8%A1&tl=th&client=tw-ob",
            usageExample = "สบายดีไหมคะ (sà-baai dee mǎi ká) — How are you? (polite question)"
        ),
        ThaiWord(
            id = 3,
            english = "I'm fine",
            thai = "สบายดี",
            phonetic = "sà-baai dee",
            category = "Greetings",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%9A%E0%B8%B2%E0%B8%A2%E0%B8%94%E0%B8%B5&tl=th&client=tw-ob",
            usageExample = "สบายดีค่ะ (sà-baai dee kâ) — I'm fine (polite, female)"
        ),
        ThaiWord(
            id = 4,
            english = "Thank you",
            thai = "ขอบคุณ",
            phonetic = "kàwp-kun",
            category = "Greetings",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%82%E0%B8%AD%E0%B8%9A%E0%B8%84%E0%B8%B8%E0%B8%93&tl=th&client=tw-ob",
            usageExample = "ขอบคุณค่ะ (kàwp-kun kâ) — Thank you (polite, female)"
        ),
        ThaiWord(
            id = 5,
            english = "Goodbye",
            thai = "ลาก่อน",
            phonetic = "laa gàwn",
            category = "Greetings",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%A5%E0%B8%B2%E0%B8%81%E0%B9%88%E0%B8%AD%E0%B8%99&tl=th&client=tw-ob",
            usageExample = "ลาก่อนนะคะ (laa gàwn ná ká) — Goodbye (soft, polite)"
        ),
        ThaiWord(
            id = 6,
            english = "Sorry / Excuse me",
            thai = "ขอโทษ",
            phonetic = "kǎw-tôht",
            category = "Greetings",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%82%E0%B8%AD%E0%B9%82%E0%B8%97%E0%B8%A9&tl=th&client=tw-ob",
            usageExample = "ขอโทษค่ะ (kǎw-tôht kâ) — Sorry / Excuse me (polite)"
        ),

        // ── MUAY THAI ─────────────────────────────────────────────────────────

        ThaiWord(
            id = 10,
            english = "Boxing (Muay Thai)",
            thai = "มวยไทย",
            phonetic = "muay tai",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%A1%E0%B8%A7%E0%B8%A2%E0%B9%84%E0%B8%97%E0%B8%A2&tl=th&client=tw-ob",
            usageExample = "มวยไทย is the art of eight limbs — fists, elbows, knees, shins."
        ),
        ThaiWord(
            id = 11,
            english = "Punch / Fist",
            thai = "หมัด",
            phonetic = "màt",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AB%E0%B8%A1%E0%B8%B1%E0%B8%94&tl=th&client=tw-ob",
            usageExample = "หมัดตรง (màt dtrong) — straight punch / jab"
        ),
        ThaiWord(
            id = 12,
            english = "Kick",
            thai = "เตะ",
            phonetic = "dtè",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%80%E0%B8%95%E0%B8%B0&tl=th&client=tw-ob",
            usageExample = "เตะตัด (dtè dtàt) — roundhouse kick (low kick)"
        ),
        ThaiWord(
            id = 13,
            english = "Elbow",
            thai = "ศอก",
            phonetic = "sàwk",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%A8%E0%B8%AD%E0%B8%81&tl=th&client=tw-ob",
            usageExample = "ศอกตี (sàwk dtee) — slashing elbow strike"
        ),
        ThaiWord(
            id = 14,
            english = "Knee",
            thai = "เข่า",
            phonetic = "kào",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%80%E0%B8%82%E0%B9%88%E0%B8%B2&tl=th&client=tw-ob",
            usageExample = "เข่าตรง (kào dtrong) — straight knee strike"
        ),
        ThaiWord(
            id = 15,
            english = "Push kick (teep)",
            thai = "ถีบ",
            phonetic = "tèep",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%96%E0%B8%B5%E0%B8%9A&tl=th&client=tw-ob",
            usageExample = "ถีบตรง (tèep dtrong) — front push kick"
        ),
        ThaiWord(
            id = 16,
            english = "Clinch",
            thai = "ปล้ำ",
            phonetic = "bplâm",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%9B%E0%B8%A5%E0%B9%89%E0%B8%B3&tl=th&client=tw-ob",
            usageExample = "ปล้ำคอ (bplâm kaw) — neck clinch"
        ),
        ThaiWord(
            id = 17,
            english = "Fight!",
            thai = "ชก",
            phonetic = "chók",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%8A%E0%B8%81&tl=th&client=tw-ob",
            usageExample = "Used when the referee signals the fighters to engage."
        ),
        ThaiWord(
            id = 18,
            english = "Trainer / Coach",
            thai = "ครู",
            phonetic = "kruu",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%84%E0%B8%A3%E0%B8%B9&tl=th&client=tw-ob",
            usageExample = "ครูมวย (kruu muay) — Muay Thai trainer / teacher"
        ),
        ThaiWord(
            id = 19,
            english = "Gym / Camp",
            thai = "ค่ายมวย",
            phonetic = "kâai muai",
            category = "Muay Thai",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%84%E0%B9%88%E0%B8%B2%E0%B8%A2%E0%B8%A1%E0%B8%A7%E0%B8%A2&tl=th&client=tw-ob",
            usageExample = "ค่ายมวย is the traditional Thai boxing camp where fighters live and train."
        ),

        // ── NUMBERS ───────────────────────────────────────────────────────────

        ThaiWord(
            id = 20,
            english = "One",
            thai = "หนึ่ง",
            phonetic = "nèung",
            category = "Numbers",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AB%E0%B8%99%E0%B8%B6%E0%B9%88%E0%B8%87&tl=th&client=tw-ob",
            usageExample = "หนึ่ง สอง สาม (nèung sǎwng sǎam) — one, two, three"
        ),
        ThaiWord(
            id = 21,
            english = "Two",
            thai = "สอง",
            phonetic = "sǎwng",
            category = "Numbers",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%AD%E0%B8%87&tl=th&client=tw-ob",
            usageExample = "สองร้อย (sǎwng ráwy) — two hundred"
        ),
        ThaiWord(
            id = 22,
            english = "Three",
            thai = "สาม",
            phonetic = "sǎam",
            category = "Numbers",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%B2%E0%B8%A1&tl=th&client=tw-ob",
            usageExample = "สามรอบ (sǎam râwp) — three rounds (as in Muay Thai rounds)"
        ),
        ThaiWord(
            id = 23,
            english = "Four",
            thai = "สี่",
            phonetic = "sèe",
            category = "Numbers",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%B5%E0%B9%88&tl=th&client=tw-ob",
            usageExample = "สี่เซ็ต (sèe set) — four sets"
        ),
        ThaiWord(
            id = 24,
            english = "Five",
            thai = "ห้า",
            phonetic = "hâa",
            category = "Numbers",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AB%E0%B9%89%E0%B8%B2&tl=th&client=tw-ob",
            usageExample = "ห้านาที (hâa naa-tee) — five minutes"
        ),
        ThaiWord(
            id = 25,
            english = "Ten",
            thai = "สิบ",
            phonetic = "sìp",
            category = "Numbers",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%B4%E0%B8%9A&tl=th&client=tw-ob",
            usageExample = "สิบครั้ง (sìp kráng) — ten times / ten reps"
        ),

        // ── FOOD ──────────────────────────────────────────────────────────────

        ThaiWord(
            id = 30,
            english = "Rice",
            thai = "ข้าว",
            phonetic = "kâao",
            category = "Food",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%82%E0%B9%89%E0%B8%B2%E0%B8%A7&tl=th&client=tw-ob",
            usageExample = "ข้าวสวย (kâao sǔuay) — steamed rice"
        ),
        ThaiWord(
            id = 31,
            english = "Water",
            thai = "น้ำ",
            phonetic = "nám",
            category = "Food",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%99%E0%B9%89%E0%B8%B3&tl=th&client=tw-ob",
            usageExample = "น้ำเปล่า (nám bplào) — plain water"
        ),
        ThaiWord(
            id = 32,
            english = "Chicken",
            thai = "ไก่",
            phonetic = "gài",
            category = "Food",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%84%E0%B8%81%E0%B9%88&tl=th&client=tw-ob",
            usageExample = "ข้าวไก่ (kâao gài) — chicken rice"
        ),
        ThaiWord(
            id = 33,
            english = "Egg",
            thai = "ไข่",
            phonetic = "kài",
            category = "Food",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%84%E0%B8%82%E0%B9%88&tl=th&client=tw-ob",
            usageExample = "ไข่เจียว (kài jieow) — Thai-style omelet"
        ),
        ThaiWord(
            id = 34,
            english = "Delicious",
            thai = "อร่อย",
            phonetic = "à-ràwy",
            category = "Food",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AD%E0%B8%A3%E0%B9%88%E0%B8%AD%E0%B8%A2&tl=th&client=tw-ob",
            usageExample = "อร่อยมาก (à-ràwy mâak) — very delicious!"
        ),
        ThaiWord(
            id = 35,
            english = "Not spicy",
            thai = "ไม่เผ็ด",
            phonetic = "mâi pèt",
            category = "Food",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%84%E0%B8%A1%E0%B9%88%E0%B9%80%E0%B8%9C%E0%B9%87%E0%B8%94&tl=th&client=tw-ob",
            usageExample = "ไม่เผ็ดค่ะ (mâi pèt kâ) — Not spicy, please (important for Crohn's!)"
        ),

        // ── ESSENTIALS ────────────────────────────────────────────────────────

        ThaiWord(
            id = 40,
            english = "Yes",
            thai = "ใช่",
            phonetic = "châi",
            category = "Essentials",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%83%E0%B8%8A%E0%B9%88&tl=th&client=tw-ob",
            usageExample = "ใช่ค่ะ (châi kâ) — Yes (polite, female)"
        ),
        ThaiWord(
            id = 41,
            english = "No",
            thai = "ไม่",
            phonetic = "mâi",
            category = "Essentials",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%84%E0%B8%A1%E0%B9%88&tl=th&client=tw-ob",
            usageExample = "ไม่เป็นไร (mâi bpen rai) — No problem / never mind"
        ),
        ThaiWord(
            id = 42,
            english = "How much?",
            thai = "เท่าไหร่",
            phonetic = "tâo-rài",
            category = "Essentials",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B9%80%E0%B8%97%E0%B9%88%E0%B8%B2%E0%B9%84%E0%B8%AB%E0%B8%A3%E0%B9%88&tl=th&client=tw-ob",
            usageExample = "นี่เท่าไหร่คะ (nêe tâo-rài ká) — How much is this?"
        ),
        ThaiWord(
            id = 43,
            english = "Where?",
            thai = "ที่ไหน",
            phonetic = "têe-nǎi",
            category = "Essentials",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%97%E0%B8%B5%E0%B9%88%E0%B9%84%E0%B8%AB%E0%B8%99&tl=th&client=tw-ob",
            usageExample = "ห้องน้ำอยู่ที่ไหนคะ (hâwng-nám yùu têe-nǎi ká) — Where is the bathroom?"
        ),
        ThaiWord(
            id = 44,
            english = "I want...",
            thai = "อยาก",
            phonetic = "yàak",
            category = "Essentials",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AD%E0%B8%A2%E0%B8%B2%E0%B8%81&tl=th&client=tw-ob",
            usageExample = "อยากกินข้าว (yàak gin kâao) — I want to eat rice"
        ),

        // ── POLITE PARTICLES ──────────────────────────────────────────────────

        ThaiWord(
            id = 50,
            english = "Polite particle (female)",
            thai = "ค่ะ / คะ",
            phonetic = "kâ / ká",
            category = "Polite",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%84%E0%B9%88%E0%B8%B0&tl=th&client=tw-ob",
            usageExample = "ค่ะ (kâ) at end of statements, คะ (ká) at end of questions. Essential for polite female speech."
        ),
        ThaiWord(
            id = 51,
            english = "Polite particle (male)",
            thai = "ครับ",
            phonetic = "kráp",
            category = "Polite",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%84%E0%B8%A3%E0%B8%B1%E0%B8%9A&tl=th&client=tw-ob",
            usageExample = "ครับ (kráp) — added at the end of sentences for polite male speech."
        ),
        ThaiWord(
            id = 52,
            english = "Beautiful",
            thai = "สวย",
            phonetic = "sǔuay",
            category = "Polite",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%AA%E0%B8%A7%E0%B8%A2&tl=th&client=tw-ob",
            usageExample = "สวยมาก (sǔuay mâak) — very beautiful"
        ),
        ThaiWord(
            id = 53,
            english = "I love / I like",
            thai = "ชอบ",
            phonetic = "châwp",
            category = "Polite",
            audioUrl = "https://translate.google.com/translate_tts?ie=UTF-8&q=%E0%B8%8A%E0%B8%AD%E0%B8%9A&tl=th&client=tw-ob",
            usageExample = "ชอบมวยไทย (châwp muay tai) — I like Muay Thai"
        )
    )

    private fun buildKnowledgeTopics(): List<KnowledgeTopic> = listOf(

        // ── CYBERSECURITY ─────────────────────────────────────────────────────

        KnowledgeTopic(
            id = 1,
            title = "Zero Trust Architecture",
            category = "Cybersecurity",
            content = "Zero Trust is a security model that requires strict verification for every person and device trying to access resources, regardless of whether they're inside or outside the network perimeter. The principle is 'never trust, always verify.' Every access request is fully authenticated, authorized, and encrypted before granting access.",
            keyTakeaway = "Never trust, always verify — even inside the network."
        ),
        KnowledgeTopic(
            id = 2,
            title = "Authentication vs Authorization",
            category = "Cybersecurity",
            content = "Authentication (AuthN) verifies WHO you are — proving identity through passwords, biometrics, or tokens. Authorization (AuthZ) determines WHAT you can access — permissions and roles that control which resources you're allowed to use. Authentication always comes first.",
            keyTakeaway = "AuthN = Who are you? AuthZ = What can you do?"
        ),
        KnowledgeTopic(
            id = 3,
            title = "OWASP Top 10 Overview",
            category = "Cybersecurity",
            content = "The OWASP Top 10 is a regularly updated list of the most critical web application security risks. It includes: Broken Access Control, Cryptographic Failures, Injection, Insecure Design, Security Misconfiguration, Vulnerable Components, Authentication Failures, Data Integrity Failures, Logging Failures, and Server-Side Request Forgery.",
            keyTakeaway = "Know the OWASP Top 10 — it's the foundation of application security."
        ),
        KnowledgeTopic(
            id = 4,
            title = "Social Engineering Attacks",
            category = "Cybersecurity",
            content = "Social engineering exploits human psychology rather than technical vulnerabilities. Common attacks include phishing (fake emails), pretexting (creating scenarios to gain trust), baiting (leaving infected USB drives), and tailgating (following authorized people into secure areas). The best defense is security awareness training.",
            keyTakeaway = "Humans are often the weakest link — train people, not just systems."
        ),

        // ── EXERCISE SCIENCE ──────────────────────────────────────────────────

        KnowledgeTopic(
            id = 10,
            title = "Delayed Onset Muscle Soreness (DOMS)",
            category = "Exercise Science",
            content = "DOMS is the muscle soreness that peaks 24–48 hours after unfamiliar or intense exercise. It's caused by microscopic tears in muscle fibers during eccentric (lengthening) contractions. This is normal and part of how muscles grow stronger. Active recovery, gentle stretching, and adequate protein intake help manage it.",
            keyTakeaway = "Soreness 1–2 days after exercise is normal and means your muscles are adapting."
        ),
        KnowledgeTopic(
            id = 11,
            title = "Progressive Overload Principle",
            category = "Exercise Science",
            content = "To get stronger, you must gradually increase the demands placed on your muscles over time. This can mean more weight, more reps, more sets, or less rest time. The key is gradual progression — small increases over weeks and months, not big jumps that risk injury.",
            keyTakeaway = "Small, consistent increases in difficulty drive long-term strength gains."
        ),
        KnowledgeTopic(
            id = 12,
            title = "Rest & Recovery Science",
            category = "Exercise Science",
            content = "Muscles don't grow during exercise — they grow during rest. Exercise creates micro-tears; sleep and recovery allow your body to repair and build them back stronger. Adults need 7–9 hours of sleep. Training the same muscle group daily without rest leads to overtraining, not gains.",
            keyTakeaway = "Your muscles grow while you sleep, not while you train."
        ),

        // ── NUTRITION SCIENCE ─────────────────────────────────────────────────

        KnowledgeTopic(
            id = 20,
            title = "Soluble vs Insoluble Fiber",
            category = "Nutrition",
            content = "Soluble fiber dissolves in water and forms a gel (oatmeal, bananas) — generally safer for Crohn's. Insoluble fiber doesn't dissolve and adds bulk (raw vegetables, whole grains) — can trigger flares. Knowing the difference helps you choose gut-friendly foods during active Crohn's periods.",
            keyTakeaway = "Soluble fiber = safer for Crohn's. Insoluble fiber = risky during flares."
        ),
        KnowledgeTopic(
            id = 21,
            title = "Anti-Inflammatory Foods",
            category = "Nutrition",
            content = "Chronic inflammation drives Crohn's disease, arthritis, and slows injury recovery. Key anti-inflammatory foods include turmeric (curcumin), ginger (gingerols), blueberries (anthocyanins), olive oil (oleocanthal), and algae-based omega-3 supplements (EPA/DHA). Consistent intake helps manage systemic inflammation.",
            keyTakeaway = "Turmeric, ginger, berries, and olive oil are your anti-inflammatory toolkit."
        ),
        KnowledgeTopic(
            id = 22,
            title = "Protein Timing for Recovery",
            category = "Nutrition",
            content = "Consuming 20–30g of protein within 1–2 hours after exercise supports muscle repair. The 'anabolic window' is real but wider than once thought — the 30-minute myth is overblown. What matters most is total daily protein intake: 0.7–1g per pound of body weight.",
            keyTakeaway = "Total daily protein matters more than exact timing — aim for 20–30g per meal."
        ),

        // ── BIOLOGY ───────────────────────────────────────────────────────────

        KnowledgeTopic(
            id = 30,
            title = "Estrogen & Muscle Development",
            category = "Biology",
            content = "Estrogen therapy affects body composition: it promotes fat redistribution to hips and thighs, may slightly reduce maximum muscle mass potential compared to testosterone-dominant systems, but absolutely does NOT prevent muscle building. Consistent resistance training still produces significant strength and muscle gains.",
            keyTakeaway = "Estrogen changes your body composition but never prevents you from getting stronger."
        ),
        KnowledgeTopic(
            id = 31,
            title = "Bone Density & Hormone Therapy",
            category = "Biology",
            content = "Estrogen is crucial for maintaining bone density. During hormone therapy, estrogen helps protect against osteoporosis. Weight-bearing exercise (walking, resistance training) further strengthens bones. Calcium and vitamin D intake support this process. Regular bone density screenings are recommended.",
            keyTakeaway = "Estrogen + weight-bearing exercise = strong bone protection."
        ),
        KnowledgeTopic(
            id = 32,
            title = "Crohn's Disease & Exercise",
            category = "Biology",
            content = "Moderate exercise actually reduces Crohn's inflammation markers and improves quality of life. High-intensity exercise during flares can worsen symptoms. The key is listening to your body: exercise during remission, rest during flares, and always stay hydrated. Low-impact activities are safest.",
            keyTakeaway = "Exercise helps Crohn's — but listen to your body and rest during flares."
        ),

        // ── MINDFULNESS ───────────────────────────────────────────────────────

        KnowledgeTopic(
            id = 40,
            title = "Box Breathing Technique",
            category = "Mindfulness",
            content = "Box breathing is used by Navy SEALs and athletes to manage stress: Inhale for 4 counts, hold for 4 counts, exhale for 4 counts, hold for 4 counts. Repeat 4–6 times. This activates the parasympathetic nervous system and immediately reduces fight-or-flight response.",
            keyTakeaway = "4-4-4-4 breathing is your fastest tool for calming anxiety."
        ),
        KnowledgeTopic(
            id = 41,
            title = "Body Scan Meditation",
            category = "Mindfulness",
            content = "A body scan involves lying down and slowly focusing attention on each body part from toes to head. Notice sensations without judgment — tension, warmth, tingling. This practice builds body awareness, which helps you recognize pain early during workouts and manage Crohn's symptoms.",
            keyTakeaway = "Scanning your body builds the awareness to prevent injuries and catch flares early."
        ),
        KnowledgeTopic(
            id = 42,
            title = "Growth Mindset",
            category = "Mindfulness",
            content = "Growth mindset (vs. fixed mindset) is the belief that abilities can be developed through effort and learning. 'I can't do this' becomes 'I can't do this yet.' This concept, researched by Carol Dweck, is essential for fitness journeys — especially when returning after long breaks.",
            keyTakeaway = "Replace 'I can't' with 'I can't yet' — every expert was once a beginner."
        )
    )
}
