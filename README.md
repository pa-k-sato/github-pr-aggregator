# pr aggregator

github の Pull Request を集計します

## usage

```bash
./gradlew bootJar; java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

### personal access token

（まだ使ってない）

personal access token で認証します。[こちら](https://docs.github.com/ja/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
を参考にして作成してください。

なお、プライベートリポジトリで利用する場合は fine-grained personal access token ではなく、 classic の access token を作成する必要があります

必要な scope は `repo`全体です

## get pull requests

gh cli で取得する

```bash
# ひとまずはこれの結果を ファイルに保存して解析する
# owner, name (repository), baseRef (base branch name) は適宜設定する
q=$(cat pr-query.txt); gh api graphql \
  -F owner='hoge' -F name='fuga' -F baseRef='bar' \
  -f query="${q}"
```

`pr-query.txt`の中身で取得する Pull Request の件数を指定しているので適宜修正して使う

