# --- ビルドステージ (Gradleでjarを作る) ---
FROM gradle:jdk17-jammy AS builder

# 作業ディレクトリ設定
WORKDIR /home/gradle/project

# ソースコードをコピー
COPY . .

# Gradleデーモンを使わず、テストをスキップしてビルド (高速化とエラー回避)
RUN gradle clean bootJar -x test --no-daemon

# --- 実行ステージ (作成されたjarを動かす) ---
FROM eclipse-temurin:17-jdk-jammy

# 作業ディレクトリ設定
WORKDIR /app

# ビルドステージから生成されたjarファイルだけをコピー
# (ファイル名が変わっても対応できるようワイルドカードを使用)
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

# ポート8080を公開 (Renderへの通知用)
EXPOSE 8080

# アプリ起動コマンド
ENTRYPOINT ["java", "-jar", "app.jar"]
