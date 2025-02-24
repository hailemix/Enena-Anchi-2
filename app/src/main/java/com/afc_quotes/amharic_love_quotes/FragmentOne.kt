package com.afc_quotes.amharic_love_quotes

import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import java.io.IOException


/**
 * Created by Haile on 7/24/2020.

 */
class FragmentOne (var nextImage: Int, var textIndex: Int) : Fragment() {

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myImageViewLayout : View = inflater.inflate(R.layout.fragment_one_layout,container,false)
        val imageView = myImageViewLayout.findViewById<ImageView>(R.id.preview)

        Glide.with(context!!).load(nextImage).transition(GenericTransitionOptions.with(R.anim.zoomin)).into(imageView)
        return myImageViewLayout

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val shareButton = view.findViewById(R.id.b1) as Button
        val wallButton = view.findViewById(R.id.wb1) as Button
        val myContent = listOf(
                "ናፍቆትሽ ከምችለዉ በላይ ሆኖብኛል፥ዉድ እባክሽን  ነይልኝ!",
                "ከሁሉም ከሁሉም የልብሽ ውበት እንዳስደነቀኝ ይኖራል",
                "ስሜ ተለየሁሽ እሹሩሩ ብዬ\n\" +\n" + "\" ቀን ሲቆጥር ደማሁ በተራሽ ነይና\n\" +\n" + "\" እሹሩሩ በይኝ ኣልቻልኩም ሆድዬ።",
                "ፍቅር አለ እንዴ..? ብዬ ቀልድኩና ያንቺ ፍቅር ከተፍ ሲል ምን ይዋጠኝ!",
                "ከንፈርሽ ውበቱ እንዲህ ነው ኣይባልም በቃ አለምን ያስረሳል!",
                "እቅፍህ ውስጥ ስገባ የሚሰማኝ ስሜት አቤት ውበቱ!",
                "ልደትሽ በአመት አንዴ የሚመጣ ቢሆንም ተጣልተን እንኳን ሁሌም አስታውሰዋለሁ",
                "ግልጽነትህ ይማርካል! ዋዉ!!!",
                "ልንገርሽ በጆሮሽ በልቤ ያለዉን፡ እኔ እሻልሻለሁ ተይው ያሰብሽውን",
                "እንዲህ ሆነን አብረን መሆን ህመም ነው፥ እስኪ ደግሞ ለብቻችን እንሞክረዉ",
                "በስሜት ማእበል እድሜያችንን ፈጀነዉ…በጣም የማዝነዉ የፍቅር ማእበል ምን እንደሚመስል ለአንድ ቀን ሳናይ ዉስጣችን ማርጀቱ ነዉ",
                "ከመሸ ፍቅራችን ደራ…ወደኋላ አንመልሰዉ ነገር ሆነብን…ቀልዳችን የምር ሲሆን፣ቅዠት ያልነዉ እዉን ሲሆን ሲጨላልም አየነዉ",
                "‹‹እኔን ለምን አታምኚኝም?›› ትለኛለህ፡፡ ለማመን የሚስማማ የዉሸት ፍቅር እያጋትከኝ  እንዴት ልመንህ?",
                "ብቸኝነቱ ከቀን ወደቀን ሊበላኝ እየደረሰ ነዉ፤ማሬ እባክህን ለየብቻችን መባከኑ ይብቃንና ቶሎ እንሰብሰብ",
                "ለምን እጅ እጅ ያለ የድግምግሞሽ ኑሮ እንኖራለን? ልባችንን እንደገና ከእንቅልፉ ይነሳና ፍቅራችን መብረቅ ይሁን!",
                "ኩርፊያሽ አቤት ደስ ሲል…! ሁሌም የምወደዉ የፍቅርሽ አንዱ ገፅታ!!",
                "አንቺን አየሁና ህይወቴን ከ ሀ እስከ ፐ ፃፍኩት!ፓ ፍቅርሽ!",
                "ልጅ እያለን ባልና ሚስት የተጫወትነዉ ትዝ ይልሃል?? አሁን ላይ አዋቂነታችን የፍቅር ቁማር ሲጫወት ሳየዉ..ምነዉ ልጅ ሆነን በቀረን እላለሁ!",
                "ጥላቻዉን ትቼ ከፍቅርሽ ጋር ተጣብቄ መኖር ሺህ ጊዜ ይሻለኛል",
                "አንድ ቃል ብቻ ከዚህ መከረኛና ፈታኝ ህይወቴ ያሳርፈኛል…እሱም ፍቅር ነዉ!",
                "በመነታረካችን ደስ ያላቸዉ ጠላቶቻችን መዋደዳችን ሲጎላባቸዉ ይደነብራሉ!",
                "ሁለመናዬ  ሁለመናሽን ይወደዋል!",
                "ፍቅርን በገንዘብ የምለቃቅም ትንፋሼን በባንክ ቡክህ ልክ የማዘምን ተራ ሰዉ አይደለሁም…ወረቀትህን ይዘን ከጎኔ ዞር በል!",
                "ለምን ትዋሸኛለህ? ለምን? ለምን??!",
                "የመፋቀራችን አላማ ደረጃ ከሌለዉ ድካም ብቻ ይሆናል…መዋደዳችን ይብሰል…መተሳሰባችን ይደግ",
                "አንተኮ ጓደኛዬ፣ልብ ወለዴና ግማሹ ማንነቴ ነህ፡፡አፈቅርሃለሁ!",
                "ጓደኛ! ‹‹ምንም ብታጠፋ አሁንም ልቤ ይቀበልሃል›› ከምትልህ ልዩ ሴት ሌላ ዉስጥህ የሚፈልግ ከሆነ እራስህን እየሸወድከዉ ነዉ!",
                "አንደኛ ነሽ ብዬ መጀመሪያ አፈቀርኩሽ…እንደሰዉ ድክመት እንዳለብሽ ያወቅኩ እለት ደግሞ የበለጠ አፈቀርኩሽ",
                "ልቤን በፍቅር አይኖችሽ አቀለጥሻቸዉ..አሁንማ ምን ልብ አለኝ!?",
                "በዚህ ምድር ላይ  ሺህ አመት ለብቻዬ ከምኖር ጥቂት አመታትን ካንቺ ጋር ማሳለፍን እመርጣለሁ",
                "መኮራረፉ እንደ ህፃን ልጅ ሲሆን ይሰለቻል..ይልቅ ፍቅርቅር ብለን መኖሩ ይሻለናል",
                "ከምር ግን ለምን ‹‹አንቺን ብቻ አፈቅርሻለሁ›› አልከኝ? የፍቅርህ አላማ አብረኸኝ ሁሌ ለመጓዝ ወይስ ለማጓጓዝ??",
                "ምሬትህ ዉስጥን ዘልቆ ይቆጠቁጣል…በስኳር የነከርከዉ ፍቅር መሳይ መርዝህ ዉስጤን አነደደዉ…አሁን በቃኝ! በቃኝ በቃኝ!",
                "በፍቅርሽ መብረቅ ድንገት ተመትቼ እየተሰቃየሁ ነዉ… በፍጥነት ነይና መድሀኒት ሁኚኝ",
                "የሰዉ ሃገር ኑሮ ቢያንገፈግፈኝም የዉስጤን ባዶነት ሊሞላዉ ይመጣል ያልኩት ሰዉ ይበልጡኑ ዉስጤን ጎዳዉ",
                "ልታገቢኝ ፈቃደኛ ከሆንሽ እንዳፈቀርኩሽ ልኖር፣ብታበሳጪኝም እንዳባበልኩሽ እድሜዬን ልገፋ በአምላኬ ፊት ምያለሁ",
               "የመዉደድህ ደስታዉ ለጥቂት ጊዜ ይቆያል..የፍቅርሽ ህመም ግን እድሜ ልኬን ሲከተለኝ ይኖራል",
                "ስላንቺ ክፉ ነገር ሲያወሩ ከመስማት ሞቴን እመርጣለሁ!",
                "ያ ሁሉ የስድብ ዉርጅብኝ ስታዘንብብኝ ዝም ማለቴ አሳመመህ? ዉስጥህ በአረም የተሞላ ተስፋ ቢስ ሰዉ ሆንክብኝ!አምላኬ ያስብህ!!",
                "ልክ ባየሁሽ ቅፅበት እንደማገባሽ አወኩ ‹ግን እኮ ገና ብዙ የምሞላቸዉ ባዶ ህልሞች ነበሩኝ!› ብሎ ሲጠይቅ የሆነዉ ማንነቴ ‹ህልሞቼ በድንገተኛ የፍቅር አደጋ ተቀይረዋል››ብሎ መለሰለት ሌላኛዉ አካሌ…",
                "ስለወደፊት ህይወታችን ስጠይቅህ…‹ተይዉ የወደፊቱን..አሁን እንኑርና እንደሰት›› ብለኸኝ ነበር…ያ ሁሉ ማስመሰል ለካ ክፉ መርዝህን ረጭተህ ዞር ለማለት ኖሯል!",
                "ዉለታህ ከአቅሜ በላይ ሆኖብኛል…ለዚህ ሁሉ ነገር መስዋእት ከፍለህ አብረኸኝ መድማትህ ልቤ ዉስጥ ልዩ ቦታ እንዲኖርህ አድርጎኛል",
                "\n\" + \"የገንዘብ ድሃ መሆኔ ብዙ ‹ቁሳቁሶችን› ቢያሳጣኝም ነገሮች መቀየራቸዉ አይቀርም…የዛኔ ግን ይብላኝ ላንቺ!\n",
                "ማንነትህ በጊዜ ብዛት ሲገለጥ እንደፈራሁት አይነት አልነበረም…መዉደድህ ለካ የምር ነበር!",
                "ልቤ ሲረበሽ እየታወቀኝ ነዉ፤የሆነ ነገርማ ሆነሻል..ለምን በግልፅ አትነግሪኝም?",
                "የተጣላን እለት እንባዬን እንኳን ለመግታት አልቻልኩም..እባክህ ይቅር በለኝ!",
                "እጄ ላይ የቀረዉን የጣቶችን ሙቀት መቼም አልረሳዉም..ቀስ እያለ የሚመጣዉ ልዩ ጠረንሽ በእያንዳንዱ ቀንና ሌሊት እያወደኝ ይኖራል!",
                "ጥለሺኝ ስትሄጂ ምን እንደተሰማኝ ታዉቂያለሽ? ልቤ እንደ ደረቀ ቅጠል ሆነ!",
                "ዉድ ጓደኛዬ…ያፈቀርኩትን ሰዉ በረቀቀዉ እዉቀትሽ ስለነጠቅሽኝ እንከዋን ደስ ያለሽ!! መልካም የፍቅር ጊዜ ይሁንላችሁ!",
                "ይሄን ሁሉ ጊዜ አብረን ስንቆይ ፍቅር አያይዞናል ብዬ አስብ ነበር፣ ነገሩ ለጋ የተገላቢጦሽ ነዉ!",
                "እዉነተኛዉ አንተንህን እፈልገዋለሁ…ፍቅርህን ድክመትህን፣ ትዝታህን ሃዘንህን ፣እሹሩሩህን፣ጊዜህን…",
                "እቅፍ አበባ ከእቅፍ ደስታ ጋር ስትለግሰኝ እቤት እንዴት ዉጤ እንደረካ…! ከወደዱ ላይቀር እንደዚህ ነዉ!",
                "ልቤን በእሳትህ ለበለብከዉ ስንቴ\n\" + \"ቶሎ ድረስልኝ ይልሃል አንጀቴ\n",
                "\n\" + \"ትንፋሽህ ነፍሴን ሲያሞቀዉ፣እጆችህ ጣቶቼን በፍቅር ሲለማመጧቸዉ፣ዛሬህ ነገዬን ሲያበራዉ ከማየት ዉጪ ምን ደስታ አለ!",
                "እህህ ይመስላል ዘላለም ሰዉ በአካል የሚኖር..\n\" + \"የት አባቴ ሄጄ ላግኝህ!!\n",
                "እራስህን ሆነህ እኔነቴን ስለምታስታዉሰኝ አንተን ላለማፍቀር ፈፅሞ አይሆንልኝም!",
                "ባለዉለታዬ ነህ፡፡ልቤ ግን ሊያፈቅርህ አልቻለም… ዉለታና ፍቅር መቼ ይሆን የሚታረቁት?",
                "የሰዉ ወሬ ማለት ሆድ ለባሰዉ ማጭድ እንደማዋስ ነዉ…ሆድሽ በኑ ቢብስም ወሬዉን ንቀሽ ተይዉ!",
                "ኦ አምላኬ! በዚህ እራስ ወዳድ ዘመን አንቺን ሳገኝ ቁማር የበሉኝን ሴቶች በትዝብት እንዲህ አልኳቸዉ…\n\" + \"‹‹አመሰግናለሁ››!\n",
                "ለኔ የከፈልሽዉ የፍቅር ዋጋ ምን ያህል ይሆን? ድራማ ሳይሆን እዉነት፣ህልም ሳይሆን በአይኔ የመሰከርኩት እዉነት ነዉ፡፡",
                "ስላሳለፍካቸዉ የመከራ አመታት በለስላሳዉ ቃላትህ ስትተርክልኝ ከልቤ ተሰማኝ…የደማዉን አካልህን ከአንጀቴ ላስታምማቸዉ እንደሚገባኝ ፍቅርህ ሹክ አለኝ",
                "ልብህ ልቤ ነዉ፣ፍቅርህ ፍቅሬ ነዉ፣ እቅፍህ ዉስጥ ሆኜ ለደቂቃ ሳሳልፍ የስቃዬን ስቃይ እረሳዋለሁ",
                "ልክ ሳይሽ የቆምኩበት ጠፋኝ..ከዛስ ከዛማ የቆምሽበት ጠፋኝ፡፡ይኸዉ ነዉ የኔና ያንቺ የፍቅር ህይወት!!",
                "አይኖችሽ ዉስጥ ብዙ ትዝታዎች ይታዩኛል፡፡ትዝ ይልሻል ያኔ…",
                "ህይወቴ በእንደዚህ አይነት ጎዳና መሄዱ ልብሽን የበለጠ እንድወደዉ አድርጎኛል",
                "ሳፈቅርህ ዉዬ ባድር አይሰለቸኝም…ግን አጣዉህ..",
                "መለያየታችን ካስደሰተሸ  መንገዱ ይኸዉ…ግን መቼም ልጠላሽ አልችልም!",
                "ተራርቀን ፍቅራችንን እስከመቼ እናጎሳቁለዉ?",
                "የሰዉ ወሬ የመፋቀራችንን ጥንካሬ ፈፅሞ አይሰብረዉም",
                "መንገዳችን እስከሞት ድረስ አይለያይም ብዬ ነበር..ግን ተለያየ",
                "ጣቶችሽን ከጣቶቼ ሲሳሳሙ ትንፋሼ ከትንፋሽስ ጋር ሲዋሃዱ ዉስጤ ከዉስጥሽ ጋር ሲግባቡ አቤት ሲያምር!",
                "አፈቅርህ እንደሆን ትደርስበታለህ\n\" +\n" + "\"እኔ ግን እንደወደድኩህ አለሁ",
                "ፍቅር ሲይዝ እንዴት ያደርጋል?ይኸዉ ልክ እንደኔ…",
                "ጉንጮችሽን ስስማቸዉ ብዉል \n\" +\n" + "\"ፀጉርሽን ስዳብሰዉ ባድር መች ሰልችቶኝ..!",
                "አንተን ከእልፍ ወንድ መካከል ስመርጥ እዉነት የሆነዉ ማንነትህ ከሩቅ ያዉደኝ ነበር",
                "ነገን ማየት የቻለ ፍቅር ከጊዜያዊ እርካታ አፈንግጦ በክብር ይቆማል",
                "እንደ ፍቅር ያለ ከባድ ማእበል አላየሁም..ሁሉንም አይነት ልብ ጠራርጎ ይወስዳል",
                "ለምን እንነታረካለን? እባክህ መዋደዱ ይሻለናል",
                "ያፈቀርኩሽ እለት ነገሮችን ከአፍ እስከገደፉ ድረስ ማየት ቻልኩ",
                "ብልጣብልጥነት በሚያጠቃዉ ትዉልድ መካከል ፍቅር እንደብርቅዬ እንስሳ በአንዳንድ ሰዎች ልብ ዉስጥ ተደብቆ ይኖራል",
                "የህይወት ልምድ ብዙ ነገር ቢያስተምረኝም የእዉነተኛ ፍቅር ኃይል ምን ያህል ከባድ እንደሆነ ልደርስበት አልቻልኩም",
                "ተዋት አትተዋት እያለ ልቤ ያሸብረኛል አልተዋት ነገር ፍቅር ሆኖብኝ..አልቀጥል ነገር በራሷ ተገፍቼ",
                "መካካድ የጀመርነዉ በቃላት ነበር..ነገሩ ጎለመሰና በፍቅራችን ላይ ጢባጢቤ ተጫወትንበት",
                "ሰቆቃ የበዛበት ጊዜያዊ ስሜት ገደል ዉስጥ ይከተናልና አሁን ይብቃን!",
                "ልብህ በፍቅር አለም ቢመዘን እንደኛ የሚወጣ ይመስለኛል…ሴት ልጅን ማፍቀር ታዉቅበታለህ!",
                "ፍቅሬ… ለኔ ማር ብቻ አይደለሽም፣ምርጥ ጓደኛዬና ሳቄ ነሽ",
                "በሃሳብ ሲነጉድ የነበረዉ ‹ሃሳቤ› በትዝታህ ገመድ ተተብትቦ ‹አረ የት ነዉ ያለኸዉ??› እያለ ዉስጤን በጠበጠዉ",
                "ከዘልማድ አስተሳሰብ ወጣ ያለዉን ብስለትህ ሁሌም ይማርከኛል፡፡ታድዬ!",
                "ነፍሴን ከነፍስህ ጋር አጋባሃቸዉ ከዛማ ላንተ ያለኝ ነገር ማፍቀር ማፍቀር..አሁንም ማፍቀር ብቻ ሆኖ ቀረ!",
                "ካንተ ጋር ስሆን እራሴን በደምብ አየዋለሁ",
                "ብዙ ሴቶች ምርኮኞችህ መሆናቸዉ እያናደደኝ እራሴ ምርኮኛህ ሆኜ መቅረቴ አሁንም ድረስ ሚስጥር ሆኖብኛል የምታነድ እሳት ሆንክብኝ! ርቄህ አልርቅህ ነገር፣ጠልቼ አልጠላህ ነገር..!",
                "ቃላቶችሽ ከባባድ ናቸዉ…ቅኔሽ ጠንከር ይላል…አፍቅሪኝ ጥዪኝ፣ ወዳጄ ሁኚ ጠላቴ መሆንሽን ለመለየት ፈተና ሆንሽብኝ",
                "የፍቅር ድር አድርተህብኝ ሄደህ እንዴት ልዉጣ…ርቀቶች ያላለያዩት ፍቅር ስላለን አመሰግናለሁ!",
                "ከንፈሬን ስትስመኝ የሆነ ነገር ዉስጤን ነዘረኝ…በእርጋታ ፀጉሮቼን ስትዳብስ የቀኑ ንዴቴ ሁሉ የት እንደጠፋ አላዉቅም")
        shareButton.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, myContent[textIndex])
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "ሼር ያድርጉ..."))
        }

        wallButton.setOnClickListener {
            val bitmap = BitmapFactory.decodeResource(resources, nextImage)
            val wallpaperManager = WallpaperManager.getInstance(context)
            val width = wallpaperManager.desiredMinimumWidth
            val height = wallpaperManager.desiredMinimumHeight
            wallpaperManager.suggestDesiredDimensions(width, height)

            try {
                wallpaperManager.setBitmap(Bitmap.createScaledBitmap(bitmap, width, height, true))
                Toast.makeText(context, "ዎልፔፐር ስእል ተደርጓል", Toast.LENGTH_SHORT).show()

            } catch (e: IOException)

            {
                e.printStackTrace()
                Toast.makeText(context, "ዎልፔፐር ስእሉ አልመጣም…እንደገና ይሞክሩ", Toast.LENGTH_SHORT).show()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }
}
