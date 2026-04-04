package com.evolutions.app.data

import com.evolutions.app.data.models.ThaiLesson
import com.evolutions.app.data.models.ScriptItem
import com.evolutions.app.data.models.ThaiBook

object ThaiContentData {

    fun getLessons(): List<ThaiLesson> = listOf(
        // ── TONES ──────────────────────────────────────────────────────────
        ThaiLesson(
            id = 1,
            title = "The 5 Thai Tones",
            subtitle = "Master the foundation of Thai pronunciation",
            category = "Tones",
            content = """Thai is a tonal language with 5 distinct tones. The same syllable pronounced with different tones creates completely different words.

🔹 Mid Tone (สามัญ) — Flat, neutral pitch. Like saying "do" in English monotone.
  Example: กา (kaa) = crow

🔹 Low Tone (เอก) — Start slightly below mid, stay low and level.
  Example: ก่า = a type of sticky substance

🔹 Falling Tone (โท) — Start high, fall sharply downward. Like saying "No!" emphatically.
  Example: ก้า = to step across

🔹 High Tone (ตรี) — Start above mid, stay high and level.
  Example: ค้า (káa) = to trade/commerce

🔹 Rising Tone (จัตวา) — Start low, rise upward. Like asking "Really?" in English.
  Example: ข้า (khâa) = servant (archaic)

⚡ Key Insight: Thai tones are RELATIVE to your natural speaking range. Don't strain — just maintain consistent pitch differences between tones.

Practice: Try saying "mai" with all 5 tones:
  ไหม (rising) = silk     ไม่ (low) = not
  ใหม่ (falling) = new    ไม้ (high) = wood
  ไหม้ (falling) = burn"""
        ),

        ThaiLesson(
            id = 2,
            title = "Mid Tone Mastery",
            subtitle = "Natural, flat pitch — the default tone",
            category = "Tones",
            content = """The mid tone is your baseline — a flat, natural pitch with no rise or fall. It's the easiest tone for English speakers.

📏 How to produce it: Speak in your natural, relaxed speaking voice. No emphasis up or down.

Mid-class consonants with live (long vowel, no final) syllables naturally produce mid tone:
  กา (kaa) = crow          จา (jaa) = to depart
  ดี (dee) = good           ตา (taa) = eye/grandfather
  บา (baa) = shoulder       ปี (bee) = year

Practice sentences:
  ตาดี (taa dee) = "good eyes" — both mid tone!
  ปูดำ (bpoo dam) = "black crab"

🎯 Tip: Record yourself saying these words and compare. The mid tone should sound completely neutral — like you're reading a phone number aloud."""
        ),

        ThaiLesson(
            id = 3,
            title = "Low Tone Mastery",
            subtitle = "Pitch drops below your natural speaking level",
            category = "Tones",
            content = """The low tone sits below your natural mid pitch. Keep it level but low — don't let it fall or rise.

📏 How to produce it: Lower your pitch slightly from neutral, then hold it steady.

Common low tone words:
  เก่า (gào) = old           ก่อน (gɔ̀ɔn) = before
  ไม่ (mâi) = not/no         น่า (nâa) = attractive/should
  เด่น (dèn) = prominent     ว่า (wâa) = to say

Mai èk (ไม้เอก) ่ is the tone mark that creates low tone on mid-class consonants:
  จ่าย (jàai) = to pay       ด่า (dàa) = to scold
  ต่อ (dtɔ̀ɔ) = to continue

Practice dialogue:
  A: ไม่ไป (mâi bpai) = "Not going"
  B: ไม่ว่า (mâi wâa) = "It's okay / doesn't matter"

🎯 Tip: Think of a disappointed "oh..." — that flat, low energy is the low tone."""
        ),

        ThaiLesson(
            id = 4,
            title = "Falling Tone Mastery",
            subtitle = "Start high, drop sharply — like emphatic English",
            category = "Tones",
            content = """The falling tone starts high and drops decisively. English speakers naturally use this when saying "No!" or "Stop!"

📏 How to produce it: Start above your natural pitch, then let it fall sharply.

Mai toh (ไม้โท) ้ is the tone mark for falling tone on mid-class consonants:
  น้ำ (náam) = water         ก้อน (gɔ̂ɔn) = lump/piece
  ใช้ (chái) = to use        ได้ (dâai) = can/able
  ช้าง (cháang) = elephant   ต้อง (dtɔ̂ng) = must

Common falling tone words:
  ข้าว (khâao) = rice        น้อง (nɔ́ɔng) = younger sibling
  ร้อน (rɔ́ɔn) = hot          ไม้ (mái) = wood/stick

Practice sentences:
  น้ำร้อน (náam rɔ́ɔn) = hot water
  ใช้ได้ (chái dâai) = usable / can use
  ต้องไป (dtɔ̂ng bpai) = must go

🎯 Tip: Say "Wow!" and notice how your pitch drops — that's the falling tone motion."""
        ),

        ThaiLesson(
            id = 5,
            title = "High Tone Mastery",
            subtitle = "Elevated, sustained pitch above neutral",
            category = "Tones",
            content = """The high tone stays above your natural speaking pitch. Keep it level and high — like speaking in a slightly excited voice.

📏 How to produce it: Raise your pitch above neutral and hold it steady. Don't let it fall.

High tone occurs naturally with:
• High-class consonants + live syllables: ขา (khǎa) = leg
• Low-class consonants + mai toh ้: ค้า (kháa) = to trade

Common high tone words:
  รู้ (rúu) = to know        สู้ (sûu) = to fight
  คุณ (khun) = you (polite)  หนู (nǔu) = mouse
  ผู้ (phûu) = person/who    หู (hǔu) = ear

Practice:
  คุณรู้ไหม (khun rúu mǎi) = Do you know?
  หนูสู้ (nǔu sûu) = The mouse fights

🎯 Tip: Imagine answering a phone cheerfully — "Hello?" — that elevated pitch is your high tone."""
        ),

        ThaiLesson(
            id = 6,
            title = "Rising Tone Mastery",
            subtitle = "Start low, sweep upward — like asking a question",
            category = "Tones",
            content = """The rising tone starts low and sweeps upward. English speakers naturally use this at the end of yes/no questions.

📏 How to produce it: Begin below your natural pitch, then smoothly glide up.

The rising tone occurs with:
• Mid-class consonants + mai jattawa ๊: — (rare)
• High-class consonants + long vowel + no final: ขา (khǎa) = leg

Common rising tone words:
  ไหม (mǎi) = question particle    ที่ไหน (thîi nǎi) = where
  สาม (sǎam) = three               ไหว้ (wâai) = to bow/greet
  ห้า (hâa) = five                   ผ้า (phâa) = cloth

Practice conversations:
  ไปไหม (bpai mǎi) = Shall we go?
  อยู่ที่ไหน (yùu thîi nǎi) = Where is it?
  สามร้อย (sǎam rɔ́ɔi) = three hundred

🎯 Tip: Say "huh?" — notice how your voice naturally rises. That's the rising tone motion applied to a full syllable."""
        ),

        ThaiLesson(
            id = 7,
            title = "Tone Practice & Minimal Pairs",
            subtitle = "Train your ear with words that differ only by tone",
            category = "Tones",
            content = """Minimal pairs are words with identical consonants and vowels but different tones. Mastering these trains both your ears and your mouth.

🔄 "mai" Minimal Pairs (all five tones):
  ไหม (mǎi) rising = silk / question particle
  ไม่ (mâi) low = not, no
  ใหม่ (mài) low = new
  ไม้ (mái) high = wood, stick
  ไหม้ (mâi) falling = to burn

🔄 "khao" Minimal Pairs:
  เขา (khǎo) rising = he/she/they; mountain
  ข้าว (khâao) falling = rice
  เข้า (khâo) falling = to enter
  ขาว (khǎao) rising = white

🔄 "suai" Minimal Pairs:
  สวย (sǔuai) rising = beautiful
  ซวย (suai) mid = unlucky

🔄 "klai" Minimal Pairs:
  ไกล (klai) mid = far
  ใกล้ (glâi) falling = near

💡 Practice Strategy:
1. Say each pair back-to-back, exaggerating the tone difference
2. Have someone quiz you — listen and identify the tone
3. Record yourself and compare with native pronunciation
4. Start slow, then gradually increase speed"""
        ),

        // ── PRONUNCIATION ──────────────────────────────────────────────────
        ThaiLesson(
            id = 8,
            title = "Thai Consonant Sounds",
            subtitle = "Initial and final consonant positions",
            category = "Pronunciation",
            content = """Thai consonants behave differently depending on their position in a syllable — initial or final.

🔤 Initial Position — Consonants at the start of a syllable use their full sound:
  ก = /k/ as in "go"          ค = /kh/ as in "king"
  จ = /tɕ/ as in "jar"       ช = /tɕh/ as in "church"
  ด = /d/ as in "do"          ต = /t/ as in "stop"
  บ = /b/ as in "boy"         ป = /p/ as in "spin"
  น = /n/ as in "no"          ม = /m/ as in "my"

🔤 Final Position — Many consonants change their sound:
  ก, ข, ค = /k/ (unreleased stop)  → เด็ก (dèk) = child
  ด, ต, ถ, ท, ธ, ฏ, ฐ, ฑ, ฒ, จ, ช, ซ, ศ, ษ, ส = /t/  → มด (mót) = ant
  บ, ป, พ, ฟ, ภ = /p/  → จบ (jòp) = to end
  น, ณ, ร, ล, ฬ = /n/  → กิน (kin) = to eat
  ม = /m/                → นม (nom) = milk
  ง = /ŋ/                → แมง (maaeng) = bug
  ย = /j/                → สาย (sǎai) = late/line
  ว = /w/               → แมว (maaeo) = cat

⚡ Key Rule: Final consonants in Thai are UNRELEASED — your mouth forms the position but doesn't release the air. "dèk" ends with your tongue on the roof of your mouth but no "kuh" sound comes out.

Practice: เด็ก (dek), มาก (mâak), จบ (jòp), กิน (kin)"""
        ),

        ThaiLesson(
            id = 9,
            title = "Thai Vowel Sounds",
            subtitle = "Short vowels, long vowels, and diphthongs",
            category = "Pronunciation",
            content = """Thai has 18 core vowel sounds organized into short-long pairs, plus special vowels and diphthongs.

📊 Short-Long Vowel Pairs:
  อะ /a/ — อา /aa/    (short "ah" vs long "aah")
  อิ /i/ — อี /ii/    (short "ih" vs long "ee")
  อึ /ɯ/ — อือ /ɯɯ/  (no English equivalent — unrounded "oo")
  อุ /u/ — อู /uu/    (short "oo" vs long "ooh")
  เอะ /e/ — เอ /ee/   (short "eh" vs long "ay")
  แอะ /ɛ/ — แอ /ɛɛ/  (short "a" as in "cat" vs long)
  โอะ /o/ — โอ /oo/   (short "oh" vs long "oh")
  เอาะ /ɔ/ — ออ /ɔɔ/  ("aw" as in "saw")
  เออะ /ɤ/ — เออ /ɤɤ/ (like "uh" but longer)

📊 Special Vowels & Diphthongs:
  อำ /am/     → น้ำ (náam) = water
  ไอ /ai/     → ไป (bpai) = to go
  ใอ /ai/     → ใจ (jai) = heart
  เอา /ao/    → เข้า (khâo) = to enter
  เอีย /ia/   → เบีย (bia) = beer
  เอือ /ɯa/  → เสือ (sɯ̌a) = tiger
  อัว /ua/    → ตัว (dtua) = body/self

⚡ Critical Rule: Short vowels create "dead syllables" which affect tone rules!
Long vowels in live syllables = one set of tone rules
Short vowels in dead syllables = different tone rules

Practice the difference:
  กะ (gà) short — กา (gaa) long
  ติ (dtì) short — ตี (dtii) long
  จุ (jù) short — จู (juu) long"""
        ),

        // ── PHRASES ────────────────────────────────────────────────────────
        ThaiLesson(
            id = 10,
            title = "Greetings & Self-Introduction",
            subtitle = "Essential first interactions in Thai",
            category = "Phrases",
            content = """Master the most important phrases for meeting Thai people and making a great first impression.

🙏 Greetings:
  สวัสดีครับ / สวัสดีค่ะ (sà-wàt-dee kráp/khâ) = Hello / Goodbye
  → ครับ (kráp) for men, ค่ะ (khâ) for women

  สบายดีไหม? (sà-baai dee mǎi?) = How are you?
  สบายดี (sà-baai dee) = I'm fine
  ขอบคุณ (khɔ̀ɔp-khun) = Thank you

📝 Self-Introduction:
  ชื่อ... (chûue...) = My name is...
  ผม/ดิฉัน (phǒm / dì-chǎn) = I (male / female polite)
  มาจาก... (maa jàak...) = I come from...
  อายุ...ปี (aa-yú...bpii) = I am ... years old
  ยินดีที่ได้รู้จัก (yin-dee thîi dâai rúu-jàk) = Nice to meet you

💬 Sample Conversation:
  A: สวัสดีค่ะ ชื่ออะไรคะ? (sà-wàt-dee khâ, chûue à-rai khá?)
     Hello, what is your name?
  B: สวัสดีครับ ชื่อมาร์คครับ (sà-wàt-dee kráp, chûue Mark kráp)
     Hello, my name is Mark.
  A: ยินดีที่ได้รู้จักค่ะ (yin-dee thîi dâai rúu-jàk khâ)
     Nice to meet you.
  B: ยินดีเช่นกันครับ (yin-dee chên-gan kráp)
     Nice to meet you too.

⚡ Cultural Note: Always add ครับ/ค่ะ at the end of sentences — it's not optional in polite Thai! Omitting it sounds blunt or rude."""
        ),

        ThaiLesson(
            id = 11,
            title = "At the Restaurant",
            subtitle = "Order food with confidence in Thai",
            category = "Phrases",
            content = """Thai food culture is central to daily life. These phrases will help you navigate any restaurant or street food stall.

🍜 Ordering Basics:
  ขอ... (khɔ̌ɔ...) = May I have... (most useful word!)
  เอา... (ao...) = I'll take... (casual)
  อันนี้ (an-née) = this one
  อันนั้น (an-nán) = that one

📋 Useful Phrases:
  เมนูอยู่ไหน (meh-nuu yùu nǎi?) = Where is the menu?
  แนะนำอะไร (náe-nam à-rai?) = What do you recommend?
  ไม่เผ็ด (mâi phèt) = not spicy
  เผ็ดน้อย (phèt nɔ́ɔi) = a little spicy
  ไม่ใส่ผักชี (mâi sài phàk-chee) = no cilantro
  เช็คบิล (chék bin) = check please
  อร่อยมาก (à-ròi mâak) = very delicious!

💰 Paying:
  เท่าไหร่ (thâo-rài?) = How much?
  แพงไป (phaeng bpai) = too expensive
  ลดได้ไหม (lót dâai mǎi?) = Can you reduce the price?

🚫 Dietary Restrictions:
  ไม่กินเนื้อ (mâi kin nʉ́a) = I don't eat beef
  แพ้...  (phâe...) = allergic to...
  มังสวิรัติ (mang-sà-wí-rát) = vegetarian
  เจ (jeh) = vegan (Buddhist style)"""
        ),

        ThaiLesson(
            id = 12,
            title = "Shopping & Bargaining",
            subtitle = "Navigate markets and negotiate prices",
            category = "Phrases",
            content = """Thailand's markets are vibrant! Bargaining is expected at most markets (but NOT in malls or 7-Elevens).

🛍️ Shopping Basics:
  ราคาเท่าไหร่ (raa-khaa thâo-rài?) = How much is the price?
  อันนี้เท่าไหร่ (an-née thâo-rài?) = How much is this?
  มีสีอื่นไหม (mee sǐi ùun mǎi?) = Do you have other colors?
  มีไซส์อื่นไหม (mee sai ùun mǎi?) = Do you have other sizes?
  ขอลอง (khɔ̌ɔ lɔɔng) = May I try it?

💰 Bargaining Phrases:
  ลดหน่อยได้ไหม (lót nɔ̀i dâai mǎi?) = Can you reduce a bit?
  แพงไป (phaeng bpai) = too expensive
  ...บาทได้ไหม (...bàat dâai mǎi?) = Can you do ... baht?
  ซื้อหลายชิ้น ลดได้ไหม (sʉ́ʉ lǎai chín, lót dâai mǎi?) = Buying many, can you discount?
  ตกลง (dtòk-long) = deal/agreed
  ไม่เอา (mâi ao) = I don't want it (walking away often works!)

🎯 Bargaining Strategy:
  1. Ask the price → Start at 50-60% of quoted price
  2. They counter → Meet around 70-75%
  3. If they won't budge → Walk away slowly
  4. They'll often call you back with a better price!

⚠️ Don't bargain at: 7-Eleven, malls, restaurants, places with fixed price tags"""
        ),

        // ── NUMBERS ────────────────────────────────────────────────────────
        ThaiLesson(
            id = 13,
            title = "Numbers 0-1,000,000+",
            subtitle = "Complete Thai numeral system with classifiers",
            category = "Numbers",
            content = """Thai numbers follow a logical pattern. Master 0-10 and you can build any number.

🔢 Basic Numbers (0-10):
  ๐ ศูนย์ (sǔun) = 0        ๑ หนึ่ง (nùeng) = 1
  ๒ สอง (sɔ̌ɔng) = 2        ๓ สาม (sǎam) = 3
  ๔ สี่ (sìi) = 4            ๕ ห้า (hâa) = 5
  ๖ หก (hòk) = 6            ๗ เจ็ด (jèt) = 7
  ๘ แปด (bpàet) = 8         ๙ เก้า (gâo) = 9
  ๑๐ สิบ (sìp) = 10

🔢 Teens (11-19): สิบ + unit
  ๑๑ สิบเอ็ด (sìp-èt) = 11  (Note: 1 becomes เอ็ด when not first digit!)
  ๑๒ สิบสอง (sìp-sɔ̌ɔng) = 12
  ๑๕ สิบห้า (sìp-hâa) = 15

🔢 Tens (20-90): unit + สิบ
  ๒๐ ยี่สิบ (yîi-sìp) = 20  (Note: 2 becomes ยี่ in tens place!)
  ๓๐ สามสิบ (sǎam-sìp) = 30
  ๕๐ ห้าสิบ (hâa-sìp) = 50

🔢 Large Numbers:
  ๑๐๐ ร้อย (rɔ́ɔi) = 100
  ๑,๐๐๐ พัน (phan) = 1,000
  ๑๐,๐๐๐ หมื่น (mùuen) = 10,000
  ๑๐๐,๐๐๐ แสน (sǎen) = 100,000
  ๑,๐๐๐,๐๐๐ ล้าน (láan) = 1,000,000

🔢 Combined Example:
  ๒๕๖ = สองร้อยห้าสิบหก (sɔ̌ɔng-rɔ́ɔi-hâa-sìp-hòk)
  ๑,๒๓๔ = หนึ่งพันสองร้อยสามสิบสี่
  ๓,๕๐๐ = สามพันห้าร้อย (no "zero" needed)"""
        ),

        // ── GRAMMAR ────────────────────────────────────────────────────────
        ThaiLesson(
            id = 14,
            title = "Thai Sentence Structure (SVO)",
            subtitle = "Build sentences with Subject-Verb-Object order",
            category = "Grammar",
            content = """Great news: Thai sentence structure is the same as English — Subject + Verb + Object (SVO)!

📐 Basic Pattern: Subject + Verb + Object
  ผม กิน ข้าว (phǒm kin khâao) = I eat rice
  เขา พูด ภาษาไทย (khǎo phûut phaa-sǎa thai) = He/she speaks Thai
  แม่ ทำ อาหาร (mâe tham aa-hǎan) = Mom makes food

📐 With Adjectives (follow the noun):
  อาหารอร่อย (aa-hǎan à-ròi) = food (is) delicious
  รถ สีแดง (rót sǐi daeng) = car red (red car)
  บ้าน ใหญ่ (bâan yài) = house big (big house)

📐 No conjugation!
Thai verbs don't change for tense, person, or number:
  ผมไป (phǒm bpai) = I go / I went / I will go
  เขาไป (khǎo bpai) = He goes / He went
  พวกเราไป (phûuak rao bpai) = We go / We went

📐 Time words go at the beginning or end:
  วันนี้ ผมไปตลาด (wan-née phǒm bpai dtà-làat) = Today I go to the market
  เมื่อวาน ฝนตก (mûua-waan fǒn dtòk) = Yesterday it rained
  พรุ่งนี้ จะไป (phrûng-née jà bpai) = Tomorrow will go

⚡ Key Insight: Thai has NO articles (a/an/the), NO verb conjugation, and NO plurals. Context tells all!"""
        ),

        ThaiLesson(
            id = 15,
            title = "Polite Particles: ครับ & ค่ะ",
            subtitle = "Essential gender-based politeness markers",
            category = "Grammar",
            content = """ครับ (kráp) and ค่ะ/คะ (khâ/khá) are the most important words in polite Thai. They're added to the END of sentences.

👨 Men use: ครับ (kráp)
  สวัสดีครับ (sà-wàt-dee kráp) = Hello
  ขอบคุณครับ (khɔ̀ɔp-khun kráp) = Thank you
  ใช่ครับ (châi kráp) = Yes

👩 Women use: ค่ะ (khâ) for statements, คะ (khá) for questions
  สวัสดีค่ะ (sà-wàt-dee khâ) = Hello
  ขอบคุณค่ะ (khɔ̀ɔp-khun khâ) = Thank you
  ใช่ไหมคะ? (châi mǎi khá?) = Is that right?

📋 When to use:
  ✅ End of every polite sentence
  ✅ When answering questions
  ✅ When acknowledging someone (like "yes" or "mm-hmm")
  ✅ When greeting or saying goodbye

📋 When you can skip:
  ❌ Between very close friends
  ❌ When talking to yourself
  ❌ In very casual texting (but adding it is always safe)

💡 Thai Language Tip for Trans Women:
  As a trans woman (สาวประเภทสอง), you may use ค่ะ/คะ to match your gender identity. Thai society generally respects this choice, especially in urban areas like Bangkok. Many Thai people will appreciate your effort to speak politely regardless of which particle you use.

⚡ Rule: When in doubt, ALWAYS add ครับ/ค่ะ. Omitting it is the #1 way foreigners accidentally sound rude!"""
        ),

        ThaiLesson(
            id = 16,
            title = "Negation with ไม่",
            subtitle = "Making negative sentences in Thai",
            category = "Grammar",
            content = """Negation in Thai is beautifully simple: just put ไม่ (mâi) before the verb!

📐 Pattern: Subject + ไม่ + Verb
  ผมไม่ไป (phǒm mâi bpai) = I'm not going
  เขาไม่ชอบ (khǎo mâi chɔ̂ɔp) = He/she doesn't like
  ฉันไม่รู้ (chǎn mâi rúu) = I don't know
  ไม่เป็นไร (mâi bpen rai) = It's okay / never mind

📐 With Adjectives: Subject + ไม่ + Adjective
  อาหารไม่เผ็ด (aa-hǎan mâi phèt) = food not spicy
  ไม่แพง (mâi phaeng) = not expensive
  ไม่ไกล (mâi klai) = not far

📐 Special Negation Words:
  ไม่ใช่ (mâi châi) = is not / that's not right (negates nouns/identities)
    นี่ไม่ใช่ของผม (nîi mâi châi khɔ̌ɔng phǒm) = This is not mine

  ไม่มี (mâi mee) = don't have / there isn't
    ไม่มีเงิน (mâi mee ngoen) = don't have money
    ไม่มีปัญหา (mâi mee bpan-hǎa) = no problem

  อย่า (yàa) = don't! (command/prohibition)
    อย่าไป! (yàa bpai!) = Don't go!
    อย่ากังวล (yàa gang-won) = Don't worry

  ยัง...ไม่ (yang...mâi) = not yet
    ยังไม่พร้อม (yang mâi phrɔ́ɔm) = not ready yet
    ยังไม่ได้กิน (yang mâi dâai kin) = haven't eaten yet"""
        ),

        ThaiLesson(
            id = 17,
            title = "Question Words",
            subtitle = "อะไร, ที่ไหน, ทำไม, เมื่อไหร่, อย่างไร",
            category = "Grammar",
            content = """Thai question words usually go at the END of the sentence (where the answer would go).

❓ Core Question Words:
  อะไร (à-rai) = what
  ใคร (khrai) = who
  ที่ไหน (thîi-nǎi) = where
  ทำไม (tham-mai) = why
  เมื่อไหร่ (mûea-rài) = when
  อย่างไร / ยังไง (yàang-rai / yang-ngai) = how
  เท่าไหร่ (thâo-rài) = how much / how many
  กี่ (gìi) = how many (with classifiers)

📝 Question Patterns:

WHAT: นี่อะไร (nîi à-rai?) = What is this?
  ทำอะไร (tham à-rai?) = What are you doing?
  กินอะไร (kin à-rai?) = What are you eating?

WHO: ใครมา (khrai maa?) = Who came?
  คนนั้นเป็นใคร (khon nán bpen khrai?) = Who is that person?

WHERE: ไปที่ไหน (bpai thîi-nǎi?) = Where are you going?
  ห้องน้ำอยู่ที่ไหน (hɔ̂ng-náam yùu thîi-nǎi?) = Where is the bathroom?

WHY: ทำไมไม่ไป (tham-mai mâi bpai?) = Why aren't you going?

WHEN: มาเมื่อไหร่ (maa mûea-rài?) = When did you come?

HOW MUCH: ราคาเท่าไหร่ (raa-khaa thâo-rài?) = How much is the price?

🔹 Yes/No Questions — add ไหม (mǎi) at the end:
  ชอบไหม (chɔ̂ɔp mǎi?) = Do you like it?
  ไปไหม (bpai mǎi?) = Are you going?
  ใช่ไหม (châi mǎi?) = Is that right?"""
        ),

        ThaiLesson(
            id = 18,
            title = "Classifiers & Counting",
            subtitle = "The Thai system for counting specific things",
            category = "Grammar",
            content = """In Thai, you can't just say "3 dogs." You need: Number + Classifier. Think of it like English "3 SHEETS of paper" or "2 CUPS of coffee."

📐 Pattern: Noun + Number + Classifier
  แมวสามตัว (maaeo sǎam dtua) = cats three [animal] = 3 cats
  คนห้าคน (khon hâa khon) = people five [person] = 5 people

📊 Essential Classifiers:
  คน (khon) = people
    เพื่อนสองคน (phûuean sɔ̌ɔng khon) = 2 friends
  ตัว (dtua) = animals, shirts, chairs, tables
    หมาตัวหนึ่ง (mǎa dtua nùeng) = 1 dog
  อัน (an) = small general objects
    ช้อนสามอัน (chɔ́ɔn sǎam an) = 3 spoons
  ใบ (bai) = flat things: paper, bags, leaves, cups
    กระดาษสิบใบ (grà-dàat sìp bai) = 10 sheets of paper
  เล่ม (lêm) = books, candles, knives
    หนังสือเล่มนี้ (nǎng-sʉ̌ʉ lêm née) = this book
  คัน (khan) = vehicles
    รถสองคัน (rót sɔ̌ɔng khan) = 2 cars
  ห้อง (hɔ̂ng) = rooms
    ห้องเดียว (hɔ̂ng diao) = 1 room
  ขวด (khùuat) = bottles
    น้ำสามขวด (náam sǎam khùuat) = 3 bottles of water

📐 THIS / THAT with Classifiers:
  Noun + Classifier + นี้/นั้น
  แมวตัวนี้ (maaeo dtua née) = this cat
  คนคนนั้น (khon khon nán) = that person"""
        ),

        ThaiLesson(
            id = 19,
            title = "Time, Days & Months",
            subtitle = "Express time and dates in Thai",
            category = "Grammar",
            content = """Learning time expressions lets you make plans, understand schedules, and navigate Thai daily life.

📅 Days of the Week:
  วันจันทร์ (wan jan) = Monday
  วันอังคาร (wan ang-khaan) = Tuesday
  วันพุธ (wan phút) = Wednesday
  วันพฤหัสบดี (wan phá-rʉ́-hàt-sà-bɔɔ-dee) = Thursday
  วันศุกร์ (wan sùk) = Friday
  วันเสาร์ (wan sǎo) = Saturday
  วันอาทิตย์ (wan aa-thít) = Sunday

⏰ Time of Day:
  เช้า (cháao) = morning    สาย (sǎai) = late morning
  เที่ยง (thîiang) = noon   บ่าย (bàai) = afternoon
  เย็น (yen) = evening      กลางคืน (klaang-khʉʉn) = night

📅 Time References:
  วันนี้ (wan-née) = today
  เมื่อวาน (mûua-waan) = yesterday
  พรุ่งนี้ (phrûng-née) = tomorrow
  สัปดาห์นี้ (sàp-daa née) = this week
  เดือนนี้ (dʉuan née) = this month
  ปีนี้ (bpii née) = this year

⏰ Telling Time (Thai system):
  Thai divides the day into 4 periods:
  ตีหนึ่ง - ตีห้า (dtii 1-5) = 1 AM - 5 AM
  หกโมงเช้า - สิบเอ็ดโมง = 6 AM - 11 AM
  เที่ยง (thîiang) = noon
  บ่ายโมง - บ่ายห้าโมง = 1 PM - 5 PM
  หกโมงเย็น - สิบเอ็ดโมง = 6 PM - 11 PM
  เที่ยงคืน (thîiang-khʉʉn) = midnight

  กี่โมง? (gìi mohng?) = What time is it?
  ตอนกี่โมง? (dtɔɔn gìi mohng?) = At what time?"""
        ),

        ThaiLesson(
            id = 20,
            title = "Making Requests & Commands",
            subtitle = "Ask politely and give instructions in Thai",
            category = "Grammar",
            content = """Thai has several levels of politeness for requests. Using the right one shows respect and cultural awareness.

🙏 Polite Requests (use with strangers, elders, service workers):
  ขอ...หน่อย (khɔ̌ɔ...nɔ̀i) = May I have... please
    ขอน้ำหน่อยครับ (khɔ̌ɔ náam nɔ̀i kráp) = May I have water please
    ขอถามหน่อย (khɔ̌ɔ thǎam nɔ̀i) = May I ask something

  ช่วย...หน่อย (chûuai...nɔ̀i) = Please help with...
    ช่วยพูดช้าหน่อย (chûuai phûut cháa nɔ̀i) = Please speak slowly
    ช่วยเขียนให้หน่อย (chûuai khǐian hâi nɔ̀i) = Please write it

  กรุณา (gà-rú-naa) = please (formal)
    กรุณารอสักครู่ (gà-rú-naa rɔɔ sàk khrûu) = Please wait a moment

📢 Casual Requests (friends, close people):
  ...หน่อย (...nɔ̀i) = ...a bit / please (casual)
    รอหน่อย (rɔɔ nɔ̀i) = wait a bit
    ดูหน่อย (duu nɔ̀i) = take a look

  ...ซิ (...sí) = go ahead and... (encouraging)
    กินซิ (kin sí) = go ahead and eat
    มาซิ (maa sí) = come on

🚫 Prohibitions:
  อย่า...! (yàa...!) = Don't...!
    อย่าวิ่ง (yàa wîng) = Don't run
  ห้าม... (hâam...) = Forbidden / Prohibited
    ห้ามสูบบุหรี่ (hâam sùup bù-rìi) = No smoking"""
        )
    )

    // ── SCRIPTS: 44 CONSONANTS ─────────────────────────────────────────
    fun getConsonants(): List<ScriptItem> = listOf(
        ScriptItem(1, "consonant", "ก", "ก ไก่", "chicken", "Mid", "/k/", "k", "Start top-left, vertical stroke down, curve right at bottom, sweep back up and over"),
        ScriptItem(2, "consonant", "ข", "ข ไข่", "egg", "High", "/kʰ/", "kh", "Start with circle head, extend vertical stroke down, curve right"),
        ScriptItem(3, "consonant", "ฃ", "ฃ ขวด", "bottle (obsolete)", "High", "/kʰ/", "kh", "Similar to ข with extended tail — rarely used in modern Thai"),
        ScriptItem(4, "consonant", "ค", "ค ควาย", "buffalo", "Low", "/kʰ/", "kh", "Start top-left, draw circle head, vertical down, curve right and up"),
        ScriptItem(5, "consonant", "ฅ", "ฅ คน", "person (obsolete)", "Low", "/kʰ/", "kh", "Similar to ค with modified tail — obsolete, not used in modern Thai"),
        ScriptItem(6, "consonant", "ฆ", "ฆ ระฆัง", "bell", "Low", "/kʰ/", "kh", "Circle head, vertical down, two curves right"),
        ScriptItem(7, "consonant", "ง", "ง งู", "snake", "Low", "/ŋ/", "ng", "Simple curve like a snake — one continuous stroke"),
        ScriptItem(8, "consonant", "จ", "จ จาน", "plate", "Mid", "/tɕ/", "j", "Circle head top, vertical down, curve right at bottom"),
        ScriptItem(9, "consonant", "ฉ", "ฉ ฉิ่ง", "cymbals", "High", "/tɕʰ/", "ch", "Top circle, long sweeping downstroke with rightward curl"),
        ScriptItem(10, "consonant", "ช", "ช ช้าง", "elephant", "Low", "/tɕʰ/", "ch", "Circle head, down and curve, with flag-like extension"),
        ScriptItem(11, "consonant", "ซ", "ซ โซ่", "chain", "Low", "/s/", "s", "Single smooth curve — one of the simplest consonants"),
        ScriptItem(12, "consonant", "ฌ", "ฌ เฌอ", "tree", "Low", "/tɕʰ/", "ch", "Complex: circle head with double-curve body"),
        ScriptItem(13, "consonant", "ญ", "ญ หญิง", "woman", "Low", "/j/", "y", "Two-part: upper curve and lower descending tail"),
        ScriptItem(14, "consonant", "ฎ", "ฎ ชฎา", "headdress", "Mid", "/d/", "d", "Like ด but with a curl at the top — Pali/Sanskrit origin"),
        ScriptItem(15, "consonant", "ฏ", "ฏ ปฏัก", "goad/spear", "Mid", "/t/", "t", "Like ต but with a curl at the top — Pali/Sanskrit origin"),
        ScriptItem(16, "consonant", "ฐ", "ฐ ฐาน", "base/pedestal", "High", "/tʰ/", "th", "Complex vertical form with internal curves"),
        ScriptItem(17, "consonant", "ฑ", "ฑ มณโฑ", "Montho (character)", "Low", "/tʰ/", "th", "Circle head with descending body"),
        ScriptItem(18, "consonant", "ฒ", "ฒ ผู้เฒ่า", "elder", "Low", "/tʰ/", "th", "Like ฑ with extra height — represents old age"),
        ScriptItem(19, "consonant", "ณ", "ณ เณร", "novice monk", "Low", "/n/", "n", "Circle head with rightward extension and tail"),
        ScriptItem(20, "consonant", "ด", "ด เด็ก", "child", "Mid", "/d/", "d", "Simple: vertical line with rightward curve at top"),
        ScriptItem(21, "consonant", "ต", "ต เต่า", "turtle", "Mid", "/t/", "t", "Vertical with a loop or circle at the top"),
        ScriptItem(22, "consonant", "ถ", "ถ ถุง", "sack/bag", "High", "/tʰ/", "th", "Compact circle with a small tail"),
        ScriptItem(23, "consonant", "ท", "ท ทหาร", "soldier", "Low", "/tʰ/", "th", "Like ถ but with longer body — low class"),
        ScriptItem(24, "consonant", "ธ", "ธ ธง", "flag", "Low", "/tʰ/", "th", "Vertical mast with flag element"),
        ScriptItem(25, "consonant", "น", "น หนู", "mouse", "Low", "/n/", "n", "Circle head with descending body curve"),
        ScriptItem(26, "consonant", "บ", "บ ใบไม้", "leaf", "Mid", "/b/", "b", "Tall vertical with small circle at top"),
        ScriptItem(27, "consonant", "ป", "ป ปลา", "fish", "Mid", "/p/", "p", "Like บ but with additional element — compare carefully"),
        ScriptItem(28, "consonant", "ผ", "ผ ผึ้ง", "bee", "High", "/pʰ/", "ph", "Circle head, vertical down, right curve with tail"),
        ScriptItem(29, "consonant", "ฝ", "ฝ ฝา", "lid/cover", "High", "/f/", "f", "Like ผ but shorter and more compact"),
        ScriptItem(30, "consonant", "พ", "พ พาน", "ceremonial tray", "Low", "/pʰ/", "ph", "Circle head with rightward body extension"),
        ScriptItem(31, "consonant", "ฟ", "ฟ ฟัน", "tooth/teeth", "Low", "/f/", "f", "Like พ with added vertical element"),
        ScriptItem(32, "consonant", "ภ", "ภ สำเภา", "sailboat/junk", "Low", "/pʰ/", "ph", "Rounded body with upward extension"),
        ScriptItem(33, "consonant", "ม", "ม ม้า", "horse", "Low", "/m/", "m", "Smooth rounded shape — one of the easiest to write"),
        ScriptItem(34, "consonant", "ย", "ย ยักษ์", "giant/demon", "Low", "/j/", "y", "Tall character with descending curve"),
        ScriptItem(35, "consonant", "ร", "ร เรือ", "boat", "Low", "/r/", "r", "Circle head with simple rightward extension"),
        ScriptItem(36, "consonant", "ล", "ล ลิง", "monkey", "Low", "/l/", "l", "Smooth flowing line — like ร but with different head"),
        ScriptItem(37, "consonant", "ว", "ว แหวน", "ring", "Low", "/w/", "w", "Simple rounded shape"),
        ScriptItem(38, "consonant", "ศ", "ศ ศาลา", "pavilion", "High", "/s/", "s", "Complex character with internal structure"),
        ScriptItem(39, "consonant", "ษ", "ษ ฤๅษี", "hermit", "High", "/s/", "s", "Like ศ but taller — Pali/Sanskrit origin"),
        ScriptItem(40, "consonant", "ส", "ส เสือ", "tiger", "High", "/s/", "s", "Most common 's' consonant — flowing shape"),
        ScriptItem(41, "consonant", "ห", "ห หีบ", "chest/box", "High", "/h/", "h", "Compact character — also used as leading consonant to change tone class"),
        ScriptItem(42, "consonant", "ฬ", "ฬ จุฬา", "kite", "Low", "/l/", "l", "Rare — circle with descending tail"),
        ScriptItem(43, "consonant", "อ", "อ อ่าง", "basin", "Mid", "/ʔ/", "ʔ", "Represents glottal stop — also used as silent vowel carrier"),
        ScriptItem(44, "consonant", "ฮ", "ฮ นกฮูก", "owl", "Low", "/h/", "h", "The last consonant — flowing rounded shape")
    )

    // ── SCRIPTS: VOWELS ────────────────────────────────────────────────
    fun getVowels(): List<ScriptItem> = listOf(
        ScriptItem(101, "vowel", "อะ", "sara a", "short /a/", "Short", "/a/", "a", "Written after consonant"),
        ScriptItem(102, "vowel", "อา", "sara aa", "long /aː/", "Long", "/aː/", "aa", "Written after consonant: กา = kaa"),
        ScriptItem(103, "vowel", "อิ", "sara i", "short /i/", "Short", "/i/", "i", "Written above consonant"),
        ScriptItem(104, "vowel", "อี", "sara ii", "long /iː/", "Long", "/iː/", "ii", "Written above consonant: กี = kii"),
        ScriptItem(105, "vowel", "อึ", "sara ue", "short /ɯ/", "Short", "/ɯ/", "ue", "Written above consonant — no English equivalent"),
        ScriptItem(106, "vowel", "อือ", "sara uee", "long /ɯː/", "Long", "/ɯː/", "uee", "Above + after consonant: กือ = kuee"),
        ScriptItem(107, "vowel", "อุ", "sara u", "short /u/", "Short", "/u/", "u", "Written below consonant"),
        ScriptItem(108, "vowel", "อู", "sara uu", "long /uː/", "Long", "/uː/", "uu", "Written below consonant: กู = kuu"),
        ScriptItem(109, "vowel", "เอะ", "sara e", "short /e/", "Short", "/e/", "e", "Written before + after consonant"),
        ScriptItem(110, "vowel", "เอ", "sara ee", "long /eː/", "Long", "/eː/", "ee", "Written before consonant: เก = kee"),
        ScriptItem(111, "vowel", "แอะ", "sara ae", "short /ɛ/", "Short", "/ɛ/", "ae", "Written before + after consonant"),
        ScriptItem(112, "vowel", "แอ", "sara aee", "long /ɛː/", "Long", "/ɛː/", "aee", "Written before consonant: แก = kaee"),
        ScriptItem(113, "vowel", "โอะ", "sara o", "short /o/", "Short", "/o/", "o", "Written before + after consonant"),
        ScriptItem(114, "vowel", "โอ", "sara oh", "long /oː/", "Long", "/oː/", "oh", "Written before consonant: โก = koh"),
        ScriptItem(115, "vowel", "เอาะ", "sara aw", "short /ɔ/", "Short", "/ɔ/", "aw", "Written before + after consonant"),
        ScriptItem(116, "vowel", "ออ", "sara aw", "long /ɔː/", "Long", "/ɔː/", "aw", "Written after consonant: กอ = kaw"),
        ScriptItem(117, "vowel", "เออะ", "sara oe", "short /ɤ/", "Short", "/ɤ/", "oe", "Written before + after consonant"),
        ScriptItem(118, "vowel", "เออ", "sara oee", "long /ɤː/", "Long", "/ɤː/", "oee", "Written before + after: เกอ = koee"),
        ScriptItem(119, "vowel", "อำ", "sara am", "am", "Special", "/am/", "am", "Combines vowel + final consonant: น้ำ = náam"),
        ScriptItem(120, "vowel", "ไอ", "sara ai (mai malai)", "ai", "Special", "/aj/", "ai", "Written before consonant: ไก = kai"),
        ScriptItem(121, "vowel", "ใอ", "sara ai (mai muan)", "ai", "Special", "/aj/", "ai", "Only 20 words use ใ — memorize them!"),
        ScriptItem(122, "vowel", "เอา", "sara ao", "ao", "Special", "/aw/", "ao", "Written before + after: เกา = kao"),
        ScriptItem(123, "vowel", "เอีย", "sara ia", "ia", "Special", "/ia/", "ia", "เบีย = bia (beer)"),
        ScriptItem(124, "vowel", "เอือ", "sara uea", "uea", "Special", "/ɯa/", "uea", "เสือ = sʉ̌a (tiger)"),
        ScriptItem(125, "vowel", "อัว", "sara ua", "ua", "Special", "/ua/", "ua", "ตัว = dtua (body)")
    )

    // ── SCRIPTS: TONE RULES ────────────────────────────────────────────
    fun getToneRules(): List<ScriptItem> = listOf(
        ScriptItem(201, "tone_rule", "📏", "Live vs Dead Syllables", "Foundation of tone rules", "Rule", "", "",
            "LIVE syllable = ends in long vowel OR sonorant final (น, ม, ง, ย, ว)\nDEAD syllable = ends in short vowel OR stop final (ก, บ, ด)\n\nThis distinction is critical because tone rules differ for live vs dead syllables!"),
        ScriptItem(202, "tone_rule", "🟢", "Mid-Class Tone Rules", "ก จ ฎ ฏ ด ต บ ป อ", "Rule", "", "",
            "Mid class + live syllable = MID tone (กา = kaa, mid)\nMid class + dead syllable = LOW tone (กะ = kà, low)\nMid class + ่ (mai ek) = LOW tone (ก่า = kàa)\nMid class + ้ (mai toh) = FALLING tone (ก้า = kâa)\nMid class + ๊ (mai tri) = HIGH tone (ก๊า = káa)\nMid class + ๋ (mai jattawa) = RISING tone (ก๋า = kǎa)"),
        ScriptItem(203, "tone_rule", "🔴", "High-Class Tone Rules", "ข ฃ ฉ ฐ ถ ผ ฝ ศ ษ ส ห", "Rule", "", "",
            "High class + live syllable = RISING tone (ขา = khǎa)\nHigh class + dead syllable = LOW tone (ขะ = khà)\nHigh class + ่ (mai ek) = LOW tone (ข่า = khàa)\nHigh class + ้ (mai toh) = FALLING tone (ข้า = khâa)\nHigh class CANNOT use ๊ or ๋ tone marks"),
        ScriptItem(204, "tone_rule", "🔵", "Low-Class Tone Rules", "ค ฅ ฆ ง ช ซ ฌ ญ ฑ ฒ ณ ท ธ น พ ฟ ภ ม ย ร ล ว ฬ ฮ", "Rule", "", "",
            "Low class + live syllable = MID tone (คา = khaa, mid)\nLow class + dead, short vowel = HIGH tone (คะ = khá)\nLow class + dead, long vowel = FALLING tone (คาก = khâak)\nLow class + ่ (mai ek) = FALLING tone (ค่า = khâa)\nLow class + ้ (mai toh) = HIGH tone (ค้า = kháa)\nLow class CANNOT use ๊ or ๋ tone marks"),
        ScriptItem(205, "tone_rule", "🔑", "Leading ห (hor nam)", "Changes low-class to high-class rules", "Rule", "", "",
            "When ห precedes a low-class sonorant (น ม ง ญ ณ ย ร ล ว), it's SILENT and changes the tone rules to HIGH-class:\n\nหน (nǎ) — ห is silent, น follows high-class rules → RISING tone\nหมา (mǎa) = dog (rising tone, not mid!)\nหลาย (lǎai) = many\nหนู (nǔu) = mouse/young person\n\nWithout ห: นา (naa) = rice field (mid tone)\nWith ห: หนา (nǎa) = thick (rising tone)")
    )

    // ── SCRIPTS: READING PASSAGES ──────────────────────────────────────
    fun getPassages(): List<ScriptItem> = listOf(
        ScriptItem(301, "passage", "📖", "Passage 1: At the Market",
            "Beginner reading practice", "Passage", "", "",
            "Thai: วันนี้ฉันไปตลาด ซื้อผักและผลไม้ มะม่วงอร่อยมาก\n\nRomanization: wan-née chǎn bpai dtà-làat, sʉ́ʉ phàk láe phǒn-lá-máai, má-mûuang à-ròi mâak\n\nTranslation: Today I went to the market. I bought vegetables and fruit. The mango was very delicious."),
        ScriptItem(302, "passage", "📖", "Passage 2: My Family",
            "Beginner reading practice", "Passage", "", "",
            "Thai: ครอบครัวของฉันมีสี่คน พ่อ แม่ พี่สาว และฉัน พ่อทำงานที่โรงพยาบาล แม่สอนหนังสือ\n\nRomanization: khrɔ̂ɔp-khrua khɔ̌ɔng chǎn mee sìi khon — phɔ̂ɔ, mâe, phîi-sǎao, láe chǎn. phɔ̂ɔ tham-ngaan thîi rohng-phá-yaa-baan. mâe sɔ̌ɔn nǎng-sʉ̌ʉ.\n\nTranslation: My family has four people — father, mother, older sister, and me. Father works at the hospital. Mother teaches."),
        ScriptItem(303, "passage", "📖", "Passage 3: Thai Food",
            "Intermediate reading practice", "Passage", "", "",
            "Thai: อาหารไทยมีชื่อเสียงไปทั่วโลก ต้มยำกุ้งเป็นอาหารที่คนต่างชาติชอบมาก มีรสเปรี้ยว เผ็ด และเค็ม ส่วนผสมหลักคือ ตะไคร้ ใบมะกรูด พริก และน้ำมะนาว\n\nTranslation: Thai food is famous around the world. Tom Yum Goong is a dish that foreigners love. It's sour, spicy, and salty. The main ingredients are lemongrass, kaffir lime leaves, chili, and lime juice."),
        ScriptItem(304, "passage", "📖", "Passage 4: Muay Thai",
            "Intermediate reading practice", "Passage", "", "",
            "Thai: มวยไทยเป็นศิลปะการต่อสู้ที่เก่าแก่ที่สุดของไทย นักมวยไทยใช้หมัด เท้า เข่า และศอก เป็นอาวุธ ก่อนชกจะมีพิธีไหว้ครู เรียกว่า รำมวย\n\nTranslation: Muay Thai is Thailand's oldest martial art. Thai boxers use fists, feet, knees, and elbows as weapons. Before fighting, there is a teacher-respect ceremony called Ram Muay."),
        ScriptItem(305, "passage", "📖", "Passage 5: Bangkok",
            "Advanced reading practice", "Passage", "", "",
            "Thai: กรุงเทพมหานครเป็นเมืองหลวงของประเทศไทย มีประชากรมากกว่าสิบล้านคน เป็นศูนย์กลางเศรษฐกิจ การศึกษา และวัฒนธรรม นักท่องเที่ยวจากทั่วโลกมาเที่ยวกรุงเทพฯทุกปี\n\nTranslation: Bangkok is the capital of Thailand. It has a population of over ten million people. It's the center of the economy, education, and culture. Tourists from around the world visit Bangkok every year.")
    )

    // ── LIBRARY: PUBLIC DOMAIN BOOKS ──────────────────────────────────
    fun getBooks(): List<ThaiBook> = listOf(
        ThaiBook(
            id = 1,
            title = "พระอภัยมณี (Phra Aphai Mani)",
            author = "Sunthorn Phu (สุนทรภู่)",
            language = "Thai Classic",
            description = "Thailand's greatest epic poem, written by the legendary Sunthorn Phu in the early 19th century. Tells the tale of Prince Aphai Mani who is abducted by a sea giantess and must escape using his magical flute. A sweeping romance of adventure, love, and the triumph of virtue across kingdoms and oceans.",
            sampleText = "กลอนบทแรก:\nอันความรักเหมือนโรคา\nบันดาลตาให้มืดมน\nไม่เห็นดีในตัวตน\nเพราะชื่นชมในเสน่หา\n\nTranslation:\nLove is like a sickness,\nit blinds the eyes to darkness.\nOne cannot see the good in oneself,\nfor one is drunk on affection."
        ),
        ThaiBook(
            id = 2,
            title = "สามก๊ก (Sam Kok)",
            author = "Chaophraya Phra Khlang (Hon) — Thai adaptation",
            language = "Thai Classic",
            description = "The Thai adaptation of the Chinese classic Romance of the Three Kingdoms, translated during the reign of King Rama I. This epic tale of strategy, loyalty, and warfare across the Three Kingdoms period has become deeply embedded in Thai culture and language.",
            sampleText = "เรื่องสามก๊กเป็นเรื่องใหญ่ที่คนไทยรู้จักกันดี กล่าวถึงความแตกแยกของแผ่นดินจีนออกเป็นสามก๊ก คือ วุยก๊ก จ๊กก๊ก และง่อก๊ก\n\nTranslation:\nSam Kok is a great story well-known to Thai people. It tells of the division of China into three kingdoms: Wei, Shu, and Wu."
        ),
        ThaiBook(
            id = 3,
            title = "ขุนช้างขุนแผน (Khun Chang Khun Phaen)",
            author = "Multiple poets (Royal Court tradition)",
            language = "Thai Classic",
            description = "One of the masterpieces of Thai literature, this epic poem tells the dramatic love triangle between the beautiful Wan Thong, the handsome warrior Khun Phaen, and the wealthy but unattractive Khun Chang. Set in the Ayutthaya period, it explores love, loyalty, jealousy, and tragic fate.",
            sampleText = "ณ กรุงศรีอยุธยา มีเศรษฐีใหญ่คนหนึ่ง ชื่อ ขุนช้าง รูปร่างอ้วนท้วนหน้าตาไม่งาม แต่มีทรัพย์สินเงินทองมากมาย\n\nTranslation:\nIn the city of Ayutthaya, there was a great wealthy man named Khun Chang. He was plump and not handsome, but possessed great riches."
        ),
        ThaiBook(
            id = 4,
            title = "อิเหนา (Inao)",
            author = "King Rama II (พระบาทสมเด็จพระพุทธเลิศหล้านภาลัย)",
            language = "Thai Classic",
            description = "A masterwork of Thai dramatic literature adapted from the Javanese Panji tales by King Rama II himself. Considered the finest example of Thai dramatic verse (บทละคร), Inao tells of a Javanese prince's romantic adventures and is renowned for its beautiful poetic language.",
            sampleText = "เสียงลือเสียงเล่าอ้าง อันใด พี่เอย\nเสียงย่อมยอยศให้ ทั่วหล้า\nสองเขือพี่หลับใหล ลืมตื่น ฤๅพี่\nสองพี่ยอดแก้วฟ้า สุดที่รัก\n\nTranslation:\nWhat fame, what tales are told? Dear one,\nVoices praising you spread across the land.\nDo you sleep and forget to wake, dear one?\nYou, my jewel of the sky, are my greatest love."
        ),
        ThaiBook(
            id = 5,
            title = "ลิลิตพระลอ (Lilit Phra Lo)",
            author = "Anonymous (Ayutthaya period)",
            language = "Thai Classic",
            description = "Often called the most beautiful love story in Thai literature. This poetic tale recounts the doomed love of King Phra Lo who falls under an irresistible love spell and travels to meet two princesses, Phra Phuean and Phra Phaeng. Tragedy ensues in this Thai Romeo and Juliet.",
            sampleText = "สองพี่เลี้ยงเจ้า จึ่งว่า\nเห็นร่มไม้พฤกษา งามเหลือ\nร่มเย็นเป็นจำนรรจา ควรจอด หยุดนา\nหยุดยั้งลำเรือ นั่งมาใต้ร่มไม้\n\nTranslation:\nThe two attendants then said,\n'See the shade of the beautiful trees,\nCool and inviting — we should stop.\nLet us moor the boat and sit beneath the shade.'"
        ),
        ThaiBook(
            id = 6,
            title = "Alice's Adventures in Wonderland",
            author = "Lewis Carroll",
            language = "English Classic",
            description = "The beloved 1865 novel following Alice as she falls down a rabbit hole into a fantastical underground world populated by peculiar creatures. A masterpiece of literary nonsense and wordplay that continues to enchant readers worldwide. Public domain since 1907.",
            sampleText = "Alice was beginning to get very tired of sitting by her sister on the bank, and of having nothing to do: once or twice she had peeped into the book her sister was reading, but it had no pictures or conversations in it, 'and what is the use of a book,' thought Alice 'without pictures or conversations?'\n\nSo she was considering in her own mind (as well as she could, for the hot day made her feel very sleepy and stupid), whether the pleasure of making a daisy-chain would be worth the trouble of getting up and picking the daisies, when suddenly a White Rabbit with pink eyes ran close by her."
        ),
        ThaiBook(
            id = 7,
            title = "Aesop's Fables",
            author = "Aesop",
            language = "English Classic",
            description = "Timeless collection of short fables attributed to the Greek storyteller Aesop (620-564 BCE). Each story features animals or natural elements that teach moral lessons about human nature. These tales have been translated into virtually every language and remain cornerstones of world literature.",
            sampleText = "THE TORTOISE AND THE HARE\n\nA Hare one day ridiculed the short feet and slow pace of the Tortoise, who replied, laughing: 'Though you be swift as the wind, I will beat you in a race.' The Hare, believing her assertion to be simply impossible, assented to the proposal; and they agreed that the Fox should choose the course and fix the goal.\n\nOn the day appointed for the race the two started together. The Tortoise never for a moment stopped, but went on with a slow but steady pace straight to the end of the course. The Hare, lying down by the wayside, fell fast asleep. At last waking up, and moving as fast as he could, he saw the Tortoise had reached the goal, and was comfortably dozing after her fatigue.\n\nSlow but steady wins the race."
        ),
        ThaiBook(
            id = 8,
            title = "The Jungle Book",
            author = "Rudyard Kipling",
            language = "English Classic",
            description = "The classic 1894 collection of stories set in the jungles of India. Most famous for the tales of Mowgli, a boy raised by wolves who learns the law of the jungle from Baloo the bear and Bagheera the panther while facing the threat of the tiger Shere Khan. Public domain worldwide.",
            sampleText = "It was seven o'clock of a very warm evening in the Seeonee hills when Father Wolf woke up from his day's rest, scratched himself, yawned, and spread out his paws one after the other to get rid of the sleepy feeling in their tips. Mother Wolf lay with her big gray nose dropped across her four tumbling, squealing cubs, and the moon shone into the mouth of the cave where they all lived.\n\n'Augrh!' said Father Wolf. 'It is time to hunt again.'"
        ),
        ThaiBook(
            id = 9,
            title = "The Adventures of Tom Sawyer",
            author = "Mark Twain",
            language = "English Classic",
            description = "Mark Twain's 1876 masterpiece about a mischievous boy growing up along the Mississippi River. Tom's adventures with his friend Huckleberry Finn — from whitewashing fences to witnessing a murder to treasure hunting — paint a vivid portrait of American frontier life. Public domain.",
            sampleText = "'TOM!'\nNo answer.\n'TOM!'\nNo answer.\n'What's gone with that boy, I wonder? You TOM!'\nNo answer.\n\nThe old lady pulled her spectacles down and looked over them about the room; then she put them up and looked out under them. She seldom or never looked through them for so small a thing as a boy; they were her state pair, the pride of her heart, and were built for 'style,' not service — she could have seen through a pair of stove-lids just as well."
        ),
        ThaiBook(
            id = 10,
            title = "Thai-English Bilingual Primer",
            author = "Public Domain Collection",
            language = "Bilingual",
            description = "A bilingual reading primer designed for Thai language learners. Features parallel Thai-English texts covering everyday topics: introductions, daily routines, food, travel, and Thai culture. Each passage includes Thai script, romanization, and English translation side by side.",
            sampleText = "บทที่ 1: แนะนำตัว (Lesson 1: Self Introduction)\n\nสวัสดีค่ะ ฉันชื่อสมหญิง อายุยี่สิบห้าปี เป็นคนกรุงเทพฯ ตอนนี้ทำงานเป็นครูสอนภาษาไทย ชอบอ่านหนังสือและทำอาหาร\n\nRomanization: sà-wàt-dee khâ, chǎn chûue Sǒm-yǐng, aa-yú yîi-sìp-hâa bpii, bpen khon Krung-thêep. dtɔɔn-née tham-ngaan bpen khruu sɔ̌ɔn phaa-sǎa Thai. chɔ̂ɔp àan nǎng-sʉ̌ʉ láe tham aa-hǎan.\n\nTranslation: Hello, my name is Somying. I am 25 years old. I am from Bangkok. I currently work as a Thai language teacher. I like reading books and cooking."
        )
    )
}
