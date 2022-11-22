# design

ツールの仕様の意思決定の過程

## 「いつ」の PR かはどうやって決める？

- PR の最初？最後？どちらを取る？
  - 「最後」を取ると確定情報だけを集計できる
  - 「最初」を取ると進行中の情報も集計できる。
  - このツールでやりたいのは結果の集計なので進行中のものはノイズになるかも？
    - ファイル数とか変更行数とかは変わりうる
    - そもそも PR 生存期間は終了しないと取れない
  - 「最後」がどの期間に位置するかで集計する

## PR の始まりはコミット？ PR 作成

- 「PR の」と書いているが取りたいのはその PR の作業期間
- とすると「コミット」になる
  - 朝から作業して夕方 PR 作ってすぐに approve されてマージ、という状況も考えられる
  - その場合、この PR の作業時間は朝から夕方になってほしい

## json 読み込みライブラリ

`kotlinx-serialization`か`jackson`のようなライブラリを使うか

基本的に外部ライブラリは java 向けである。 kotlin でも使えるはずだが微妙に予期せぬ動作をする場合があるらしいので`kotlinx-serialization`を使う

ただし、`webclient`で読むようになった時は`spring`に依存するのでその時は`spring`が依存するライブラリを使った方が楽、とかはあるかもしれない

spring webflux でも kotlinx-serialization 使えそう？
<https://docs.spring.io/spring-framework/docs/current/reference/html/languages.html#kotlin-multiplatform-serialization>

### 参考

- [公式？](https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serialization-guide.md)