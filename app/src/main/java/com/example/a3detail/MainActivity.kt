package com.example.a3detail

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 结论：尽量使用xml来布局界面
         */


        //setContentView(R.layout.activity_main)
        //用代码来构建界面
        //MainActivity -> ..... -> Context

        /**
         * 默认情况下 在代码中写的尺寸都是pix 像素
         * 代码中写 100 == 100px
         * 运行起来之后 在手机上显示的也是100px
         * 但是手机有不同的分辨率Density
         *      一个dp有多少个px
         *      密度为1  则对应的值为 100dp  = 100px
         *      密度为2  则对应的值为 50dp *2 == 100
         *      密度为5  则对应的值为 20dp *5 == 100
         *
         */
        //addLinearLayoutKotlin()

        /**
         * 手动创建RelativeLayout容器 进行界面布局
         * 每一个布局容器都有自己的LayoutParams
         */
        //addRelativeLayout()

        /**
         * 手动创建ConstraintLayout容器 进行界面布局
         */
        addConstraintLayout()
    }

    private fun addConstraintLayout(){
        val constraintLayout = ConstraintLayout(this).apply {
            id = R.id.mContainer
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )
            background = getDrawable(R.color.colorPrimaryDark)
            setContentView(this)
        }

        ImageView(this).apply {
            id = R.id.mHeader
            layoutParams = ConstraintLayout.LayoutParams(dp2px(120), dp2px(90)).apply {
                //左边和父容器对齐
                leftToLeft = R.id.mContainer
                //顶部和父容器对齐
                topToTop = R.id.mContainer
                setMargins(dp2px(10),dp2px(10),0,0)
            }
            setImageResource(R.drawable.header)
            scaleType = ImageView.ScaleType.CENTER_CROP
            constraintLayout.addView(this)
        }

        TextView(this).apply {
            id = R.id.mTitle
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            ).apply {
                leftToRight = R.id.mHeader
                rightToRight = R.id.mContainer
                topToTop = R.id.mHeader
                bottomToBottom = R.id.mHeader
                setMargins(dp2px(10),0,dp2px(10),0)
            }
            text = "美国计划再买4艘医疗船抗击新冠疫情 此前2艘仅收治200余名患者"
            setTextColor(getColor(R.color.colorWhite))
            textSize  = 20f
            constraintLayout.addView(this)
        }

        TextView(this).apply {
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            ).apply {
                leftToLeft = R.id.mHeader
                rightToRight = R.id.mTitle
                topToBottom = R.id.mHeader
                bottomToBottom = R.id.mContainer
                setMargins(0,dp2px(10),0,0)
            }
            text = "参考消息网7月29日报道美国消费者新闻与商业频道网站近日发表美国退役四星上将、布鲁金斯学会会长约翰·艾伦和布鲁金斯学会治理研究中心副主任达雷尔·韦斯特的文章称，部署基于人工智能的武器有重大机遇，但也存在日益增加的重大威胁。虽然人工智能可以放大军事能力，但它也可能在本质上破坏稳定。文章摘编如下：\n" +
                    "\n" +
                    "美国最近派遣两个航母战斗群进入南海，以显示军事实力。这一举动是回应中国在南海水域举行军事演习。当中美这两个“超级大国”都在人工智能、远程成像和无人化武器系统方面发展先进技术能力之际，这场对峙加剧了全球紧张关系。重要的是，两国官员都应明白，新兴技术能够加快决策过程，但同时也会加大误判的风险。"

            setTextColor(getColor(R.color.colorWhite))
            textSize  = 20f
            constraintLayout.addView(this)
        }
    }

    private fun addRelativeLayout(){
        //创建RelativeLayout容器
        val relativeLayout = RelativeLayout(this).apply {
            //宽高
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )
            //添加id值
            id = R.id.mContainer
            //设置背景颜色
            background = getDrawable(R.color.colorPrimaryDark)
            //将这个容器视图添加到Activity对应的界面上
            setContentView(this)
        }

        //添加图片
        ImageView(this).apply {
            //添加ID
            id = R.id.mHeader
            layoutParams =  RelativeLayout.LayoutParams(dp2px(120),dp2px(90)).apply {
                setMargins(dp2px(10),dp2px(10),0,0)
            }
            setImageResource(R.drawable.header)
            scaleType = ImageView.ScaleType.CENTER_CROP
            relativeLayout.addView(this)
        }

        //添加标题
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(0,0).apply {
                id = R.id.mTitle
                //设置和其他控件的相对关系
                //和头像的相对关系
                addRule(RelativeLayout.RIGHT_OF, R.id.mHeader)
                //和父容器右边对齐
                addRule(RelativeLayout.ALIGN_PARENT_END, R.id.mContainer)
                //和头像顶部对齐
                addRule(RelativeLayout.ALIGN_TOP, R.id.mHeader)
                //和头像底部对齐
                addRule(RelativeLayout.ALIGN_BOTTOM, R.id.mHeader)
                //和头像的间距
                marginStart = dp2px(10)
                marginEnd = dp2px(10)
            }
            text = "美国计划再买4艘医疗船抗击新冠疫情 此前2艘仅收治200余名患者"
            setTextColor(getColor(R.color.colorWhite))
            textSize  = 20f
            relativeLayout.addView(this)
        }

        //添加内容
        TextView(this).apply {
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT
                ,0).apply {
                //设置和其他控件的相对关系
                //在头像的下方
                addRule(RelativeLayout.BELOW, R.id.mHeader)
                //和头像左边对齐
                addRule(RelativeLayout.ALIGN_START, R.id.mHeader)
                //和标题的右边对齐
                addRule(RelativeLayout.ALIGN_END, R.id.mTitle)
                //和父容器的底部对齐
                addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, R.id.mContainer)
                //background = getDrawable(R.color.colorWhite)
                //顶部间距
                setMargins(0,dp2px(10),0,0)
            }
            text = "参考消息网7月29日报道美国消费者新闻与商业频道网站近日发表美国退役四星上将、布鲁金斯学会会长约翰·艾伦和布鲁金斯学会治理研究中心副主任达雷尔·韦斯特的文章称，部署基于人工智能的武器有重大机遇，但也存在日益增加的重大威胁。虽然人工智能可以放大军事能力，但它也可能在本质上破坏稳定。文章摘编如下：\n" +
                    "\n" +
                    "美国最近派遣两个航母战斗群进入南海，以显示军事实力。这一举动是回应中国在南海水域举行军事演习。当中美这两个“超级大国”都在人工智能、远程成像和无人化武器系统方面发展先进技术能力之际，这场对峙加剧了全球紧张关系。重要的是，两国官员都应明白，新兴技术能够加快决策过程，但同时也会加大误判的风险。"

            setTextColor(getColor(R.color.colorWhite))
            textSize  = 20f
            relativeLayout.addView(this)
        }
    }

    private fun addLinearLayoutKotlin(){
        // 创建容器 LinearLayout
        val container = LinearLayout(this).apply {
            // 设置宽高
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            )
            // 方向
            orientation = LinearLayout.VERTICAL
            //设置颜色
            background = getDrawable(R.color.colorPrimary)
        }.also { setContentView(it) }

        // 创建第一个子控件 为横向布局的LinearLayout
        LinearLayout(this).apply {
            //获取屏幕的密度
            // 设置宽高
            layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,dp2px(100))
            // 方向
            orientation = LinearLayout.HORIZONTAL
            //设置颜色
            background = getDrawable(R.color.colorPrimaryDark)
            //将当前的这个子控件添加到父容器中
            container.addView(this)
        }.apply {
            // 图片
            ImageView(this@MainActivity).apply {
                // 宽高
                layoutParams = LinearLayout.LayoutParams(
                    dp2px(120),
                    LinearLayout.LayoutParams.MATCH_PARENT
                )

                //设置图片资源
                setImageResource(R.drawable.header)

                //设置填充模式
                scaleType = ImageView.ScaleType.CENTER_CROP

                //添加到容器中
                addView(this)
            }

            //添加标题
            TextView(this@MainActivity).apply {
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.MATCH_PARENT
                ).apply {
                    weight = 1f
                    setMargins(dp2px(10),dp2px(10),dp2px(10),dp2px(10))
                }

                text = "美国计划再买4艘医疗船抗击新冠疫情 此前2艘仅收治200余名患者"
                setTextColor(getColor(R.color.colorWhite))
                textSize  = 20f
                addView(this)
            }
        }

        // 创建第二个子控件 TextView
        TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
                ).apply {
                setMargins(dp2px(10),dp2px(10),dp2px(10),dp2px(10))
            }
            text = "参考消息网7月29日报道美国消费者新闻与商业频道网站近日发表美国退役四星上将、布鲁金斯学会会长约翰·艾伦和布鲁金斯学会治理研究中心副主任达雷尔·韦斯特的文章称，部署基于人工智能的武器有重大机遇，但也存在日益增加的重大威胁。虽然人工智能可以放大军事能力，但它也可能在本质上破坏稳定。文章摘编如下：\n" +
                    "\n" +
                    "美国最近派遣两个航母战斗群进入南海，以显示军事实力。这一举动是回应中国在南海水域举行军事演习。当中美这两个“超级大国”都在人工智能、远程成像和无人化武器系统方面发展先进技术能力之际，这场对峙加剧了全球紧张关系。重要的是，两国官员都应明白，新兴技术能够加快决策过程，但同时也会加大误判的风险。"
            setTextColor(getColor(R.color.colorWhite))
            textSize  = 20f
            container.addView(this)
        }
    }

    // 100   ->
    // 100 * density  = px
    fun dp2px(dp: Int): Int{
        return (resources.displayMetrics.density * dp).toInt()
    }

    private fun addLinearLayoutJava(){
        //1. 创建容器 -> LinearLayout
        val linearLayout = LinearLayout(this)

        //2. 给容器设置宽 高
        linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)

        //3. 设置布局方向
        linearLayout.orientation = LinearLayout.VERTICAL

        //   设置颜色
        linearLayout.background = getDrawable(R.color.colorAccent)

        //4. 添加容器到Activity上
        setContentView(linearLayout)
    }
}