# ひんとだよ

## やることリスト

### 1. エラーと警告消して見やすくする

- `option + Command + L`を押してみよう。  
どのIDEを使っていても、基本コードフォーマットのショートカットはあるはずだから、「なんかゴチャゴチャしてきたな」って思ったら押してみるといいよ。

- ()と{}を整理しよう。  
なんとなく感じてるかもしれんけど、今()と{}が入り混じってゴチャってきてるね。
どのかっこがどこに対応しているのか一個ずつ確認してけばわかると思うから、フォーマット後に直してこう。
今の感じだと、onBindViewHolderのかっこから直していくのオススメ。

- 警告の除去  
myDataSetとかみるとわかるんだけど、今グレーの波線が引かれてるよね。  
これは不要なコードがあるよってのをIDEが教えてくれてて、こいつがなくなるだけでスッキリしてくはず。  
`option + Enter`で自動Fix出てくるはずだから、使って直してみよう。
(`option + Enter`の自動Fixは警告でもエラーでも使えるときあるから、とりあえずやってみるといいよ。)

### 2. ViewHolderを直してみよう

- まずは一番下にもってこよ。  
別に決まりはないんだけど、ViewHolderはAdapter内の一番下に定義されてるイメージある。  
なんとなく綺麗に見えるから下に持ってきちゃお。

- mTextViewをmButtonに変更  
前回はテキストを入れてあげるやつだったけど、今回はボタン押してログを出すっていう課題だから、TextViewはいらんね！  
text_view.xmlの方でボタンを書くのはできてたから、mTextViewの代わりに作ったmButtonにfindViewByIdでbuttonを取ってきて入れてあげよう！  
今書いてあるのとやってること自体はおんなじ！

### 3. onBindViewHolder()を直してみよう
ここが今回一番むずいとこだね。  
っていってもそんなに複雑に考える必要はなくて、やらなきゃいけないことは **「holderのbuttonにクリックリスナーをつけてあげる」** これだけ。  
2でViewHolderを直せてたら、第一引数のholderからmButtonにアクセスできるはず。  
こいつに対してsetOnClickListenerを呼び出してみよう。  
ここまでできたらあとはonClickの中でログを吐き出す処理をかくだけ！

### 4. text_view.xmlを直してみよう

これは特に必要ってわけじゃないんだけどね。  
直した方が綺麗に見える。  
TextViewがいらないから消してあげて、Buttonの幅をmatch_parentに、marginを8dpにすると綺麗になるよ。

### 5. リファクタして終わり

直してる途中で崩れたとことかあると思うからまたコードフォーマットしといて〜

### マジで困ったら

これMyAdapterの答えね〜  
もう無理！ってなったら三角押してひらけば見れるよ。  
コメント色々かいてあるから、できた！ってなったら見てみるといいよ。

<details>
<summary>MyAdapter.java</summary>

``` java
package myapps.c.addrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * クラス内の定義の順番は
 * 1. 変数
 * 2. コンストラクタ
 * 3. インナークラス
 * みたいな順番がいいかも。
 * 他にもstaticとかあるから、いろんなコード見て何がどの順番で書かれていることが多いか意識して見てみると良いよ。
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    /**
     * myDataSetの配列のサイズはここで事前に決めておかなくてOK！
     * グレーの波線出てると思うからそこでoption(Windowsだとaltかも) + Enterで自動Fixしてみよ。
     */
    private String[] myDataSet;

    /**
     * 基本的に関数/コンストラクタの引数はキャメルケースで書いとこう！
     * Javaの場合はクラス名がパスカルケース、引数がキャメルケースで書く決まりがあるよ〜
     * 言語によってその辺の決まりは変わってくるよ〜
     * Javaの命名指針：https://qiita.com/rkonno/items/1b30daf83854fecbb814
     */
    MyAdapter(String[] dataSet) {
        myDataSet = dataSet;
    }

    /**
     * ここはマジで完璧。
     * 文句なし。
     */
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view, parent, false);
        return new ViewHolder(view);
    }

    /**
     * 今回のキモはこいつね。
     * 前説明したから覚えてるかもしれないけど、この関数ではリサイクルされたViewのオブジェクトとデータを結びつける役割を担ってるのね。
     * で、第一引数のholderってのがそのリサイクルされたViewのオブジェクトそのもの。
     * クラスの定義は一番下にあるViewHolderってやつで、mButtonってButtonのグローバル変数を持たせてるのね。
     * 今回はそいつに対してsetOnClickListenerを呼び出して、クリックリスナーをくっつけてあげてる。
     * リスナーの中では押したボタンのpositionも表示させてるから、どこが押されたかログからわかるようにしといたよ。
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked! Position".concat(Integer.toString(position)));
            }
        });
    }

    /**
     * 書き方がこっちのが僕好みで綺麗に見えると思ったから直しちゃったけど、内容的には文句なし。
     */
    @Override
    public int getItemCount() {
        return myDataSet.length;
    }

    /**
     * 決まりはないんだけど、ViewHolderは大体一番下に書いてあるイメージあるから移動しといた。
     * 今回は前回のTextViewの代わりにButtonを使うから、ButtonをViewHolderのグローバル変数として定義しとく。
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        ViewHolder(View v) {
            super(v);
            mButton = v.findViewById(R.id.button);
        }
    }
}

```

</details>
