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